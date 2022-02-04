package com.bksoftware.classroom.week9;

import java.util.Scanner;

public class Function {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        maxNum(10,20);
        minNum(10,20);
        System.out.println("Giai thừa của số cần tìm là "+giaiThua(0));
        System.out.println("Số fibonaci muốn tìm là: "+fibonaci(4));
        maxNum(1,2);
        maxNums(1,2,3);
        System.out.println("maxNums_ver1 "+maxNums_ver1(2,6,10));
    }
    public static void maxNum(int x, int y){
        System.out.println("Số lớn nhất trong hai số truyền vào là: "+(x>y?x:y));
    }
    public static void maxNums(int x, int y,int z) {
        System.out.println("Số lớn nhất trong ba số truyền vào là: "+(x>y?(x>z?x:z):(y>z?y:z)));
    }
    public static int maxNums_ver1(int x, int y, int z){
        if(x>=y && x>=z) return x;
        else return maxNums_ver1(y,z,x);
    }
    public static void minNum(int x, int y){
        System.out.println("Số nhỏ nhất trong hai số truyền vào là: "+(x>y?y:x));
    }
    public static int giaiThua(int x){
        if(x>=1) return x*giaiThua(x-1);
        else return 1;
    }
    public static long fibonaci(long n){
        if(n>=3) return fibonaci(n-1) + fibonaci(n-2);
        if(n==2 || n==1) return 1;
        return 0;
    }
}
