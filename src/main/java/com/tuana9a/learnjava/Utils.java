package com.tuana9a.learnjava;

import java.io.*;

public class Utils {
    public static String loadTextFile(String filePath) {
        InputStream is = null;
        String stringData = null;
        byte[] byteData;
        try {
//            is = App.class.getResourceAsStream(filePath);//CAUTION load trong
            is = new FileInputStream(filePath);//CAUTION load ngoài
            byteData = new byte[is.available()];
            int byteAmountRead = is.read(byteData);
            stringData = new String(byteData);
        } catch (Exception e) {
            System.out.println("Fail to load: \"" + filePath + "\"");
            e.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return stringData;
    }

    public static boolean writeTextFile(String filePath, String data) {
        if (data == null || data.equals("")) {
            System.out.println("not thing to write");
            return false;
        }

        File f;
        FileOutputStream fos = null;
        BufferedOutputStream bis = null;

        try {
            f = new File(filePath);
            fos = new FileOutputStream(f);
            bis = new BufferedOutputStream(fos);
            bis.write(data.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Fail to write: \"" + filePath + "\"");
            return false;
        } finally {
            try {
                if (bis != null) bis.close();
                if (fos != null) fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }
}
