package com.bksoftware.homework.week4;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        /*tính số Fibonaci thứ n*/
        Scanner input=new Scanner(System.in);
        System.out.print("Bạn muốn số Fibonaci thứ bao nhiêu trong dãy(n>=2): ");
        int n = input.nextInt();
        int a=0;
        int b=1;
        int c=a+b;
        System.out.println(a);
        System.out.println(b);
        for(int i=3;i<=n;++i){
            System.out.println(c);
            a=b;
            b=c;
            c=a+b;
        }
        System.out.println("Số Fibonaci thứ "+n+" là: "+c);


        /*tính ln(2)*/
        System.out.println("Nhập vào số chu kỳ n mà bạn muốn để tính ln(2): ");
        long m=input.nextLong();
        double result=0;
        for(long i=1;i<=m;++i){
            result += (double) (i%2==0?-1:1)/i;
        }
        System.out.println("giá trị của log(2) mà bạn muốn là: "+result);
    }
}
