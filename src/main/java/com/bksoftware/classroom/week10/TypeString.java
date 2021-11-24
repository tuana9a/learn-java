package com.bksoftware.classroom.week10;

import java.util.Scanner;

public class TypeString {
    static Scanner input = new Scanner(System.in);

    public static void ex1() {
        System.out.println("Type in the String you want to search");
        java.lang.String in = input.nextLine();
        System.out.println("Type in the index you want to know:");
        int pos = input.nextInt();
        System.out.println("Result " + in.charAt(pos));
    }

    public static void ex2() {
        System.out.println("Type in the String you want to search");
        java.lang.String in = input.nextLine();
        System.out.println("Type in the index you want to know in the Unicode:");
        int pos = input.nextInt();
        System.out.println("Result " + in.codePointAt(pos));
    }

    public static void ex3() {
        System.out.println("Type in the String you want to search");
        java.lang.String in = input.nextLine();
        System.out.println("Type in the index you want to know in the Unicode before the index:");
        int pos = input.nextInt();
        System.out.println("Result " + in.codePointBefore(pos));
    }

    public static void ex5() {
        System.out.println("Type in the first String you want to compare");
        java.lang.String in1 = input.nextLine();
        System.out.println("Type in the second String you want to compare");
        java.lang.String in2 = input.nextLine();
        int check = in1.compareTo(in2);
        if (check == 0) {
            System.out.println("String one is equal to String two");
            return;
        }
        if (check > 0) {
            System.out.println("String one is after String two");
            return;
        }
        System.out.println("String one is before String two");
    }

    public static void ex6() {
        System.out.println("Type in the first String you want to compare");
        java.lang.String in1 = input.nextLine();
        System.out.println("Type in the second String you want to compare");
        java.lang.String in2 = input.nextLine();
        int check = in1.compareToIgnoreCase(in2);
        if (check == 0) {
            System.out.println("String one is equal to String two");
            return;
        }
        if (check > 0) {
            System.out.println("String one is after String two");
            return;
        }
        System.out.println("String one is before String two");
    }

    public static void main(java.lang.String[] args) {
        java.lang.String a="hello";
        java.lang.String b= new java.lang.String("hello");
        java.lang.String c= new java.lang.String("hello");
        java.lang.String d="hello";
        a=b;
        System.out.println(a.length());
        System.out.println(a==c);
        System.out.println(a==b);
        System.out.println(a==d);
    }
}
