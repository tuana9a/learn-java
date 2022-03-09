package com.tuana9a.learn.io;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class TextFileProcess {

    public static List<String> read(String path) {
        return read(new File(path));
    }

    public static List<String> read(File file) {
        InputStream is = null;
        List<String> result = new LinkedList<>();
        try {
            is = new FileInputStream(file);
            byte[] bytes = new byte[8_192];
            int read;
            while ((read = is.read(bytes)) != -1) {
                byte[] actualBytes = new byte[read];
                System.arraycopy(bytes, 0, actualBytes, 0, read);
                result.add(new String(actualBytes));
            }

        } catch (Exception e) {
            System.out.println("Fail to load: \"" + file.getAbsolutePath() + "\"");
            e.printStackTrace();
        } finally {
            try {
                if (is != null)
                    is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    public static boolean write(List<String> data, File output) {
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        try {
            fos = new FileOutputStream(output);
            bos = new BufferedOutputStream(fos);
            for (String s : data)
                bos.write(s.getBytes());
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        } finally {
            close(bos);
            close(fos);
        }
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException ignored) {
            }
        }
    }

    public static boolean write(List<String> data, String outputPath) {
        return write(data, new File(outputPath));
    }
}
