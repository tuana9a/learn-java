package com.bksoftware.homework.week7;

import java.util.Scanner;

public class BinToDec {
    //decToBin ver that reversed anf not completed
    public static String decToBin0(int dec) {
        String result = "";
        while (dec >= 0) {
            if (dec == 1) {
                result += "1";
                break;
            }
            if (dec % 2 == 1) result += "1";
            else result += "0";
            dec = (dec - dec % 2) / 2;
        }

        return result;
    }

    //decToBin ver recursion
    static String result = "";// this variable is to store the result globally after convert decToBin1
    public static void decToBin1(int dec) {

        if (dec > 1)
            decToBin1((dec - dec % 2) / 2);//greater than 1 beacause if dec = 1 then not necessary to recursive anymore :)))
        if (dec % 2 == 1) {
            System.out.print("1");
            result += "1";
        }
        else {
            System.out.print("0");
            result += "0";
        }
    }


    public static int binToDec(String bin) {
        char[] binChar = bin.toCharArray();
        int binLength = binChar.length;
        int result = 0;
        for (int i = 0; i < binLength; ++i) {
            result += binChar[i] == '1' ? Math.pow(2, binLength - 1 - i) : 0;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(decToBin0(10));
        decToBin1(10);
        System.out.println(binToDec("100"));
    }
}
