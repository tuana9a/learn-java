package com.tuana9a.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipUtils {
    private static final ZipUtils instance = new ZipUtils();

    private ZipUtils() {

    }

    public static ZipUtils getInstance() {
        return instance;
    }

    public void unzip(File input, File output) throws IOException {
        byte[] buffer = new byte[1024];
        FileInputStream fileInputStream = new FileInputStream(input);
        ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);

        ZipEntry zipEntry = zipInputStream.getNextEntry();
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
                while ((len = zipInputStream.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
            }
            zipEntry = zipInputStream.getNextEntry();
        }

        zipInputStream.closeEntry();
        IoUtils.getInstance().close(zipInputStream);
        IoUtils.getInstance().close(fileInputStream);
    }

    private File unzipWrite(File desFolder, ZipEntry zipEntry) throws IOException {
        File desFile = new File(desFolder, zipEntry.getName());

        String desFolderPath = desFolder.getCanonicalPath();
        String desFilePath = desFile.getCanonicalPath();

        if (!desFilePath.startsWith(desFolderPath + File.separator)) {
            throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
        }

        return desFile;
    }
}
