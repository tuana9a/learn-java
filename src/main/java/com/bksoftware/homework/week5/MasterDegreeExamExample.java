package com.bksoftware.homework.week5;

import java.util.Scanner;

public class MasterDegreeExamExample {
    public static void main(String[] args) {
        /*tính số nguyên n nhỏ nhất sao cho n^2 chia hết cho A là số nhập vào*/
        Scanner input = new Scanner(System.in);
        boolean check = false;
        long a;
        do {
            System.out.print("Nhập vào số A: ");
            a = input.nextLong();
            if (a <= 0) {
                System.out.println("Bạn nhập \"khôn\" vl mời bạn làm lại");
                check = true;
            } else {
                check = false;
            }
        } while (check);
        int temp = 1;
        while (temp * temp % a != 0) {
            ++temp;
        }
        System.out.println("kết quả bài toán: " + temp);
    }
}
