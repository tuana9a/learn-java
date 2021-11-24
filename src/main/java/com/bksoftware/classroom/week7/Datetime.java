package com.bksoftware.classroom.week7;
import java.time.LocalDateTime;


public class Datetime {
    //tìm số lớn nhất trong 3 số
    public static double max3Number(double x, double y, double z){
        if(x>y&&x>z) return x;
        else return max3Number(y,z,x);
    }
    //tìm diện tích hình ngũ giác
    public static double pentagon(double x){
        return 5.0/4.0*x*x*1.0/Math.tan(Math.PI/5.0);
    }
    //tìm lãi qua từng năm
    public static void profit(double funds,double profitRate,int years){
        for(int i=1;i<=years;++i){
            funds+=(profitRate/100)*funds;
            System.out.print(i+" "+funds+"\n");
        }
    }
    //tính trung bình 3 số
    public static double aver3Number(double x, double y, double z){
        return(x+y+z)/3;
    }
    //số ngũ giác
    public static void pentagonNumber(int n){
        for(int i=1;i<=n;++i){
            System.out.println();
        }
    }
    public static void printCurrentTime(){
        LocalDateTime time = LocalDateTime.now();
        System.out.println(time.getDayOfMonth());;
    }
    public static void main(String[] args) {
        System.out.println(max3Number(10,15,20));
        System.out.println(pentagon(6));
        profit(1000,10,5);
        System.out.println(aver3Number(25,45,65));
        //System.out.println(Calendar.getInstance().toString());
        printCurrentTime();
    }
}
