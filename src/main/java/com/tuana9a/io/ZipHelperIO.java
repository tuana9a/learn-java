package com.tuana9a.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipHelperIO {

    //SECTION: zip
    public static void zipFiles(File[] files, String outputPath) throws IOException {
        if (files == null) {
            return;
        }

        FileOutputStream fos = new FileOutputStream(outputPath);
        ZipOutputStream zipOut = new ZipOutputStream(fos);
        for (File file : files) {
            FileInputStream fis = new FileInputStream(file);
            ZipEntry zipEntry = new ZipEntry(file.getName());
            zipOut.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            fis.close();
        }
        zipOut.close();
        fos.close();
    }

    public static void zipFiles(List<File> files, String outputPath) throws IOException {
        if (files == null) {
            return;
        }

        FileOutputStream fos = new FileOutputStream(outputPath);
        ZipOutputStream zipOut = new ZipOutputStream(fos);
        for (File file : files) {
            FileInputStream fis = new FileInputStream(file);
            ZipEntry zipEntry = new ZipEntry(file.getName());
            zipOut.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            fis.close();
        }
        zipOut.close();
        fos.close();
    }

    public static void zipFolder(String inputPath, String outputPath) throws IOException {
        zipFolder(new File(inputPath), new File(outputPath));
    }

    public static void zipFolder(File input, String outputPath) throws IOException {
        zipFolder(input, new File(outputPath));
    }

    public static void zipFolder(String inputPath, File output) throws IOException {
        zipFolder(new File(inputPath), output);
    }

    public static void zipFolder(File input, File output) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(output);
        ZipOutputStream zipOut = new ZipOutputStream(fileOut);

        zipWrite(input, input.getName(), zipOut);
        zipOut.close();
        fileOut.close();
    }

    private static void zipWrite(File input, String fileName, ZipOutputStream zipOut) throws IOException {
        if (input.isHidden()) {
            return;
        }

        if (input.isDirectory()) {
            if (fileName.endsWith("/")) {
                zipOut.putNextEntry(new ZipEntry(fileName));
            } else {
                zipOut.putNextEntry(new ZipEntry(fileName + "/"));
            }
            zipOut.closeEntry();
            File[] children = input.listFiles();
            if (children != null) {
                for (File childFile : children) {
                    zipWrite(childFile, fileName + "/" + childFile.getName(), zipOut);
                }
            }
            return;
        }

        FileInputStream fis = new FileInputStream(input);
        ZipEntry zipEntry = new ZipEntry(fileName);
        zipOut.putNextEntry(zipEntry);
        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }
        fis.close();
    }


    //SECTION: unzip
    public static void unzip(File input, File output) throws IOException {
        byte[] buffer = new byte[1024];
        ZipInputStream zis = new ZipInputStream(new FileInputStream(input));
        ZipEntry zipEntry = zis.getNextEntry();
        while (zipEntry != null) {
            File newFile = unzipWrite(output, zipEntry);
            if (zipEntry.isDirectory()) {
                if (!newFile.isDirectory() && !newFile.mkdirs()) {
                    throw new IOException("Failed to create directory " + newFile);
                }
            } else {
                // fix for Windows-created archives
                File parent = newFile.getParentFile();
                if (!parent.isDirectory() && !parent.mkdirs()) {
                    throw new IOException("Failed to create directory " + parent);
                }

                // write file content
                FileOutputStream fos = new FileOutputStream(newFile);
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
            }
            zipEntry = zis.getNextEntry();
        }
        zis.closeEntry();
        zis.close();
    }

    private static File unzipWrite(File destinationDir, ZipEntry zipEntry) throws IOException {
        File destFile = new File(destinationDir, zipEntry.getName());

        String destDirPath = destinationDir.getCanonicalPath();
        String destFilePath = destFile.getCanonicalPath();

        if (!destFilePath.startsWith(destDirPath + File.separator)) {
            throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
        }

        return destFile;
    }
}
