package com.bksoftware.classroom.week21;

public class Exception {
    public static void main(String[] args) {
        try {
            //System.out.println(10/0);
            try {
                System.out.println(10 / 0);
            } catch (java.lang.Exception e) {
                System.out.println("Loi trong");
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
                e.printStackTrace();
            }
            System.out.println(10/0);

        } catch (ArithmeticException e) {
            System.out.println("Loi so hoc");
        } catch (java.lang.Exception e) {
            System.out.println("Loi ngoai");
            System.out.println(e.getMessage());
//          System.out.println(e.getCause());
//          e.printStackTrace();
        } finally {
            System.out.println("what the fuck is this shit");
        }
    }
}
