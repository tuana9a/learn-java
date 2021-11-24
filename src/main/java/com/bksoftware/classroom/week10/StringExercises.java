package com.bksoftware.classroom.week10;

import java.time.LocalDateTime;
import java.util.Scanner;

public class StringExercises {
    static Scanner input = new Scanner(System.in);

    //ver của mình thì dùng kiểu của C bê sang
    public static String correctName_verMe() {
        System.out.println("Input the name you want to correct");
        String inputString = input.nextLine();
        inputString = inputString.trim();
        String result = "";
        //char[] test.temp = inputString.toCharArray();
        for (int i = 0; i < inputString.length(); ++i) {
            if (inputString.charAt(i) == ' ') {
                if (inputString.charAt(i + 1) == ' ') {
                    continue;
                }
            }
            result = result.concat(Character.toString(inputString.charAt(i)));
        }
        return result /*+ result.length()*/;
    }

    //ver anh mạnh chỉ dùng hàm không cần duyệt mảnh nhanh hơn các cái khác
    public static String correctName_verManh() {
        System.out.println("Input the name you want to correct");
        String inputString = input.nextLine();
        inputString = inputString.trim();
        String result = "";
        result = inputString.replaceAll("\\s+", " ");
        return result;
    }

    public static void ex5(String s1, String s2) {
        int check = s1.compareTo(s2);
        System.out.print("EX5:  ");
        if (check < 0) {
            System.out.println("\"" + s1 + "\"" + " is before " + "\"" + s2 + "\"");
        }
        if (check == 0) {
            System.out.println("\"" + s1 + "\"" + " is the same as " + "\"" + s2 + "\"");
        }
        if (check > 0) {
            System.out.println("\"" + s1 + "\"" + " is after " + "\"" + s2 + "\"");
        }
    }

    public static void ex6(String s1, String s2) {
        int check = s1.compareToIgnoreCase(s2);
        System.out.print("EX6:  ");
        if (check != 0) {
            System.out.println("\"" + s1 + "\"" + " is different from " + "\"" + s2 + "\"");
        }
        if (check == 0) {
            System.out.println("\"" + s1 + "\"" + " is equivalent to " + "\"" + s2 + "\"");
        }

    }

    public static void ex7(String s1, String s2) {
        String result = s1 + " and " + s2;
        System.out.print("EX7:  ");
        System.out.println("\"" + result + "\"");
    }

    public static void ex9(String s1, String s2) {
        System.out.print("EX9:  ");
        System.out.println("\"" + s1 + "\"" + (s1.equals(s2) == true ? " is the same as " : " is different from ") + "\"" + s2 + "\"");
    }

    public static void ex11(char[] a) {
        String result = "";
        for (char i : a) {
            result = result.concat(Character.toString(i));
        }
        System.out.print("EX11: ");
        System.out.println("\"" + result + "\"");
    }

    public static void ex12(String s1, String s2) {
        System.out.print("EX12: ");
        if (s1.endsWith(s2)) {
            System.out.println("\"" + s1 + "\"" + " does end with " + "\"" + s2 + "\"");
        } else {
            System.out.println("\"" + s1 + "\"" + " doesn't end with " + "\"" + s2 + "\"");
        }

    }

    public static void ex13(String s1, String s2) {
        System.out.print("EX13: ");
        if (s1.contentEquals(s2)) {
            System.out.println("\"" + s1 + "\"" + " does equal to " + "\"" + s2 + "\"");
        } else {
            System.out.println("\"" + s1 + "\"" + " doesn't equal to " + "\"" + s2 + "\"");
        }
    }

    public static void ex14(String s1, String s2) {
        System.out.print("EX14: ");
        if (s1.equalsIgnoreCase(s2)) {
            System.out.println("\"" + s1 + "\"" + " does equal to " + "\"" + s2 + "\"" + " (Ignore case sensitive)");
        } else {
            System.out.println("\"" + s1 + "\"" + " doesn't equal to " + "\"" + s2 + "\"" + " (Ignore case sensitive)");
        }
    }

    public static void ex15() {
        LocalDateTime currentTime = LocalDateTime.now();
        int currentHour = currentTime.getHour();
        System.out.print("EX15: ");
        System.out.println("Bây giờ là "
                //+ "Thứ " + currentTime.getDayOfWeek()
                + " Ngày " + currentTime.getDayOfMonth()
                + " Tháng " + currentTime.getMonthValue()
                + " Năm " + currentTime.getYear() + " "
                + (currentHour > 12 ? currentHour - 12 : currentHour) + ":"
                + currentTime.getMinute() + ":"
                //+ currentTime.getSecond()
                + (currentHour > 12 ? " Chiều" : " Sáng")
        );
    }

    public static void ex35(String in) {
        char[] charStorage = new char[in.length()];
        for (int i = 0; i < in.length(); ++i) {
            charStorage[i] = in.charAt(i);
        }
        char[] charTemp = new char[in.length()];
        ex35_recursive_ver1(charStorage, charTemp, 0);
    }

    public static void ex35_recursive_ver1(char[] charStorage, char[] charTemp, int tempPos) {
        if (tempPos == charStorage.length) {
            ex35_recursive_ver1_printResult(charTemp);
            return;//cái này phải có nếu không nó sẽ truy cập quá cái charStorage thì bị out ngay
        }
        for (int i = 0; i < charStorage.length; ++i) {
            charTemp[tempPos] = charStorage[i];
            ex35_recursive_ver1(charStorage, charTemp, tempPos + 1);
        }
    }

    public static void ex35_recursive_ver1_printResult(char[] charTemp) {
        String result = "";
        for (char c : charTemp) {
            result = result.concat(Character.toString(c));
        }
        System.out.println(result);
    }

    public static void ex40(String in) {
        System.out.println("How many pieces do you want to divide the String into");
        int n;
        do {
            n = input.nextInt();
            System.out.println(in.length() % n != 0 ? "Sorry the String length is not divisible by the number you just entered\nPlease retype it =.-" : "");
        }
        while (in.length() % n != 0);

        String[] stringStorage = new String[in.length() / n];
        for (int i = 0; i < in.length()/n; ++i) {
            stringStorage[i]="";
        }
        for (int i = 0; i < in.length(); ++i) {
            stringStorage[i / n] = stringStorage[i / n].concat(Character.toString(in.charAt(i)));
        }
        for (int i = 0; i < in.length()/n; ++i) {
            System.out.println(stringStorage[i]);
        }
    }

    public static void main(String[] args) {
//        System.out.println(correctName_verMe());
//        System.out.println(correctName_verManh());

        String s1 = new String("InnerClasss");
        String s2 = new String("tuAn");
        System.out.println("a: " + (int) ('a') + " , A: " + (int) ('A') + " and a compare to A is " + ("a").compareTo("A"));
        ex5(s1, s2);
        ex6(s1, s2);
        ex7(s1, s2);
        ex9(s1, s2);
        char[] a = {'t', 'u', 'a', 'n'};
        ex11(a);
        ex12(s1, s2);
        ex13(s1, s2);
        ex14(s1, s2);
        ex15();
        ex35("abc");
        ex40("TuanLongLinhHungQAnh");
    }
}
