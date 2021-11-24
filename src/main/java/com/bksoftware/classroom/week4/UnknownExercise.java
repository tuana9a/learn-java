package com.bksoftware.classroom.week4;

import java.util.Scanner;

public class UnknownExercise {
    public static void main(String[] args) {
        /*bài tập làm thạc sĩ khoa học máy tính*/
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập vào số phần tử: ");
        long n = input.nextInt();
        System.out.print("Nhập vào phẩn tử thứ 1: ");
        double a0=input.nextDouble();
        double sum1=a0*a0;
        double sum2=a0;
        double max=a0;
        double min=a0;
        for(int i=1;i<n;++i)
        {
            System.out.print("Nhập vào phần tử thứ "+(i+1)+": ");
            double temp = input.nextDouble();
            max=temp>=max?temp:max;
            min=temp<=min?temp:min;
            sum1+=temp*temp;
            sum2+=temp;
        }
        System.out.println(sum1*2 - 2*sum2*(min+max) + n*(min*min+max*max) + (double)n/2*(max-min)*(max-min));
    }
}
