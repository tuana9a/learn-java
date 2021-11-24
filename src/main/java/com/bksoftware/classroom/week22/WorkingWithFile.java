package com.bksoftware.classroom.week22;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class WorkingWithFile {
    public static void main(String[] args) {
        fileWrite("InnerClasss","a.txt");
    }

    public static boolean fileWrite(String data, String path) {
        boolean rs = false;
        File file;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        try {
            file = new File(path);
            fos = new FileOutputStream(file,true);
            bos = new BufferedOutputStream(fos);
            //bos.close();
            //fos.close();
            bos.write(data.getBytes());
            System.out.println(data.getBytes());
            rs = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                bos.close();
                fos.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return rs;
    }
}
