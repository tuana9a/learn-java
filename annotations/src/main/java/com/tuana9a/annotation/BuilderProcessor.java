package com.tuana9a.annotation;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.*;
import java.util.stream.Collectors;

@SupportedAnnotationTypes("com.tuana9a.annotation.Builder")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class BuilderProcessor extends AbstractProcessor {

    private static final Logger logger = Logger.getLogger(BuilderProcessor.class.getName());

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        for (TypeElement annotation : annotations) {
            Set<? extends Element> annotatedElements = roundEnv.getElementsAnnotatedWith(annotation);

            annotatedElements = annotatedElements.stream()
                    .filter(element -> element.getKind().isClass())
                    .collect(Collectors.toSet());

            annotatedElements.forEach(element -> {
                try {


                    String className = ((TypeElement) element).getQualifiedName().toString();

                    List<Element> propElements = element.getEnclosedElements()
                            .stream()
                            .filter(prop -> prop.getKind().isField())
                            .collect(Collectors.toCollection(LinkedList::new));

                    Map<String, String> propsMap = propElements.stream()
                            .collect(Collectors.toMap(
                                    prop -> prop.getSimpleName().toString(),
                                    prop -> prop.asType().toString()
                            ));

                    //NOTE: can't overwrite class like lombok
                    String result = writeClassFile(className, propsMap);

                    Handler handler = new FileHandler("./annotation-processor.log", true);
                    handler.setFormatter(new SimpleFormatter());
                    logger.addHandler(handler);
                    logger.info("make " + result + "Builder success");
                } catch (IOException e) {
                    Handler handler = new ConsoleHandler();
                    logger.addHandler(handler);
                    logger.warning(e.getMessage());
                }
            });

        }

        return true;
    }

    private String writeClassFile(String fullClassName, Map<String, String> propsMap) throws IOException {
        String packageName = null;
        int lastDot = fullClassName.lastIndexOf('.');
        if (lastDot > 0) {
            packageName = fullClassName.substring(0, lastDot);
        }

        String className = fullClassName.substring(lastDot + 1);
        String fullBuilderClassName = fullClassName + "Builder";
        String builderClassName = fullBuilderClassName.substring(lastDot + 1);

        JavaFileObject builderFile = processingEnv.getFiler().createSourceFile(fullBuilderClassName);

        try (PrintWriter writer = new PrintWriter(builderFile.openWriter())) {

            if (packageName != null) {
                writer.println("package " + packageName + ";\n");
            }

            writer.println("public class " + builderClassName + " {\n");
            writer.println("    private " + className + " object = new " + className + "();\n");

            writer.println("    public " + className + " build() { return object; }\n");

            propsMap.forEach((propName, propType) -> {
                String setMethod = "set" + propName.substring(0, 1).toUpperCase() + propName.substring(1);
                writer.println("    public " + builderClassName + " " + propName + "(" + propType + " value) {");
                writer.println("        object." + setMethod + "(value);");
                writer.println("        return this;");
                writer.println("    }\n");
            });

            writer.println("}");
        }

        return fullBuilderClassName;
    }

}
