package com.tuana9a.learnjava.reflection;

import java.lang.reflect.Field;

public class ObjectAnalyze<T> {
    private final Class<T> type;

    public ObjectAnalyze(Class<T> type) {
        this.type = type;
    }

    public T getObject() {
        try {
            Field[] fields = type.getDeclaredFields();
            T object = (T) type.newInstance();
            for (Field f : fields) {
                f.setAccessible(true);
                if (f.getName().equals("name")) {
                    f.set(object, "tuan");
                } else if(f.getName().equals("id")) {
                    f.set(object,1);
                }
            }
            return object;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void readObject(T object) {
        Field[] fields = type.getDeclaredFields();
        int fieldNumber = fields.length;
        for (int i = 0; i < fieldNumber; i++) {
            Field f = fields[i];
            f.setAccessible(true);
            try {
                System.out.printf(
                        "Field(%d)\t %-20s %-20s\n",
                        i,
                        "fieldName=\"" + f.getName() + "\"",
                        "fieldValue=\"" + f.get(object) + "\"");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
