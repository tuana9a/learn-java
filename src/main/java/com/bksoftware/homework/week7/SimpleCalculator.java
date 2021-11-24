package com.bksoftware.homework.week7;

import java.util.Scanner;

public class SimpleCalculator {
    static Scanner input = new Scanner(System.in);

    public static void menu() {
        System.out.println("Mời bạn chọn:\n1.Cộng\n2.Trừ\n3.Nhân\n4.Chia");
        int select;
        boolean check = true;
        do {
            select = input.nextInt();
            if (select < 1 || select > 4) {
                check = false;
                clearConsole();
                System.out.println("Mời bạn chọn lại:\n1.Cộng\n2.Trừ\n3.Nhân\n4.Chia");
            } else {
                check = true;
            }
        } while (!check);
        clearConsole();
        switch (select) {
            case 1:
                add();
            case 2:
                subtract();
            case 3:
                multiply();
            case 4:
                divide();
        }
    }

    public static void add() {
        System.out.println("Bạn đã chọn phép CỘNG");
        System.out.print("Nhập vào số thứ nhất: ");
        double x = input.nextDouble();
        System.out.print("Nhập vào số thứ hai:  ");
        double y = input.nextDouble();
        System.out.println("TỔNG hai số bạn vừa nhập là: " + (x + y));
        System.out.println("\nMời bạn chọn:\n1.Tiếp Tục\n2.Quay Lại");
        int select;
        boolean check = true;
        do {
            select = input.nextInt();
            if (select < 1 || select > 2) {
                check = false;
                clearConsole();
                System.out.println("Mời bạn chọn lại:\n1.Tiếp Tục\n2.Quay Lại");
            } else {
                check = true;
            }
        } while (!check);
        clearConsole();
        switch (select) {
            case 1:
                add();
            case 2:
                menu();
        }
    }

    public static void multiply() {
        System.out.println("Bạn đã chọn phép NHÂN");
        System.out.print("Nhập vào số thứ nhất: ");
        double x = input.nextDouble();
        System.out.print("Nhập vào số thứ hai:  ");
        double y = input.nextDouble();
        System.out.println("TÍCH hai số bạn vừa nhập là: " + (x * y));
        System.out.println("\nMời bạn chọn:\n1.Tiếp Tục\n2.Quay Lại");
        int select;
        boolean check = true;
        do {
            select = input.nextInt();
            if (select < 1 || select > 2) {
                check = false;
                clearConsole();
                System.out.println("Mời bạn chọn lại:\n1.Tiếp Tục\n2.Quay Lại");
            } else {
                check = true;
            }
        } while (!check);
        clearConsole();
        switch (select) {
            case 1:
                multiply();
            case 2:
                menu();
        }

    }

    public static void subtract() {
        System.out.println("Bạn đã chọn phép TRỪ");
        System.out.print("Nhập vào số thứ nhất: ");
        double x = input.nextDouble();
        System.out.print("Nhập vào số thứ hai:  ");
        double y = input.nextDouble();
        System.out.println("TRỪ hai số bạn vừa nhập được: " + (x - y));
        System.out.println("\nMời bạn chọn:\n1.Tiếp Tục\n2.Quay Lại");
        int select;
        boolean check = true;
        do {
            select = input.nextInt();
            if (select < 1 || select > 2) {
                check = false;
                clearConsole();
                System.out.println("Mời bạn chọn lại:\n1.Tiếp Tục\n2.Quay Lại");
            } else {
                check = true;
            }
        } while (!check);
        clearConsole();
        switch (select) {
            case 1:
                subtract();
            case 2:
                menu();
        }
    }

    public static void divide() {
        System.out.println("Bạn đã chọn phép CHIA");
        System.out.print("Nhập vào số thứ nhất: ");
        double x = input.nextDouble();
        System.out.print("Nhập vào số thứ hai:  ");
        double y = input.nextDouble();
        System.out.println("CHIA hai số bạn vừa nhập được: " + (x / y));
        System.out.println("\nMời bạn chọn:\n1.Tiếp Tục\n2.Quay Lại");
        int select;
        boolean check = true;
        do {
            select = input.nextInt();
            if (select < 1 || select > 2) {
                check = false;
                clearConsole();
                System.out.println("Mời bạn chọn lại:\n1.Tiếp Tục\n2.Quay Lại");
            } else {
                check = true;
            }
        } while (!check);
        clearConsole();
        switch (select) {
            case 1:
                divide();
            case 2:
                menu();
        }
    }

    public static void clearConsole() {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public static void main(String[] args) {
        menu();
    }
}
