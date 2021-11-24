package com.bksoftware.homework;

import java.util.Scanner;

public class FridayTheThirteen {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int january = 31;
        int februaryNormal = 28;
        int februarySpecial = 29;
        int march = 31;
        int april = 30;
        int may = 31;
        int june = 30;
        int july = 31;
        int august = 31;
        int september = 30;
        int october = 31;
        int november = 30;
        int december = 31;
        int leapYear=366;
        int normalYear=365;
        System.out.println("Nhập vào Ngày-Tháng-Năm sinh cách nhau bởi dấu cách hoặc Enter");
        int dateOfBirth = input.nextInt();
        int monthOfBirth = input.nextInt();
        int yearOfBirth = input.nextInt();
        System.out.println("Nhập vào Ngày-Tháng-Năm hiện tại cách nhau bởi dấu cách hoặc Enter");
        int currentDate = input.nextInt();
        int currentMonth = input.nextInt();
        int currentYear = input.nextInt();

        int daysCurrentMonth=0;
        boolean currentYearCheck=false;
        if(currentYear % 400==0 || currentYear % 4==0 && currentYear % 100 !=0){
            currentYearCheck=true;
        }else{
            currentYearCheck=false;
        }
        switch (currentMonth){
            case 1:   daysCurrentMonth=january;break;
            case 2:   daysCurrentMonth=(currentYearCheck==true)?februarySpecial:februaryNormal;break;
            case 3:   daysCurrentMonth=march;break;
            case 4:   daysCurrentMonth=april;break;
            case 5:   daysCurrentMonth=may;break;
            case 6:   daysCurrentMonth=june;break;
            case 7:   daysCurrentMonth=july;break;
            case 8:   daysCurrentMonth=august;break;
            case 9:   daysCurrentMonth=september;break;
            case 10:  daysCurrentMonth=october;break;
            case 11:  daysCurrentMonth=november;break;
            case 12:  daysCurrentMonth=december;break;
        }
        int daysMonthOfBirth=0;
        boolean yearOfBirthCheck=false;
        if(yearOfBirth % 400==0 || yearOfBirth % 4==0 && yearOfBirth % 100 !=0){
            yearOfBirthCheck=true;
        }else{
            yearOfBirthCheck=false;
        }
        switch (monthOfBirth){
            case 1:   daysMonthOfBirth=january;break;
            case 2:   daysMonthOfBirth=(yearOfBirthCheck==true)?februarySpecial:februaryNormal;break;
            case 3:   daysMonthOfBirth=march;break;
            case 4:   daysMonthOfBirth=april;break;
            case 5:   daysMonthOfBirth=may;break;
            case 6:   daysMonthOfBirth=june;break;
            case 7:   daysMonthOfBirth=july;break;
            case 8:   daysMonthOfBirth=august;break;
            case 9:   daysMonthOfBirth=september;break;
            case 10:  daysMonthOfBirth=october;break;
            case 11:  daysMonthOfBirth=november;break;
            case 12:  daysMonthOfBirth=december;break;
        }

        if(monthOfBirth>12||monthOfBirth<1||currentMonth>12||currentMonth<1||dateOfBirth>daysMonthOfBirth||dateOfBirth<1||currentDate>daysCurrentMonth||currentDate<1||yearOfBirth>currentYear||yearOfBirth<0||(yearOfBirth==currentYear && currentMonth<monthOfBirth)||(yearOfBirth==currentYear && currentMonth==monthOfBirth && currentDate < dateOfBirth)){
            System.out.println("Bạn nhập \"khôn\" như bò");
        } else {
            int dayExist=0;//số ngày tồn tại
            int tuan=0;
            int thuBanSinhRa=0;

            int chia7du0=0;   //từ đây
            int chia7du1=0;
            int chia7du2=0;
            int chia7du3=0;
            int chia7du4=0;
            int chia7du5=0;
            int chia7du6=0;   //đến đây là dùng cho việc tính thứ 6 ngày 13 trong vòng lặp khổng lồ phía dưới

            int dayOfWeek=7; //từ đây
            int date = 1;
            int month = 1;
            int year = 0;    //đến đây là để khởi tạo giá trị cho vòng lặp chạy từ lúc lịch ra đời

            int daysMonth=0;          //số ngày trong một tháng
            boolean yearCheck=false;  // check year có phải năm nhuận hay không true là nhuận false là năm không nhuận
            boolean checkWhile=false; // điều kiện tiếp tục vòng lặp while

            do{
                if(year < currentYear){
                    checkWhile=true;
                }else if(year==currentYear && month<currentMonth){
                    checkWhile=true;
                }else if(year==currentYear && month==currentMonth && date<currentDate){
                    checkWhile=true;
                }else{
                    break;
                }
                //cái if ngay trên check xem có thể làm tiếp vong lặp được không
                if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0) {
                    yearCheck = true;
                } else {
                    yearCheck = false;
                }
                //cái if ngay trên check năm của vòng lặp true là nhuận false là không nhuận
                switch (month) {
                    case 1: daysMonth = january;break;
                    case 2: daysMonth = (yearCheck == true) ? februarySpecial : februaryNormal;break;
                    case 3: daysMonth = march;break;
                    case 4: daysMonth = april;break;
                    case 5: daysMonth = may;break;
                    case 6: daysMonth = june;break;
                    case 7: daysMonth = july;break;
                    case 8: daysMonth = august;break;
                    case 9: daysMonth = september;break;
                    case 10: daysMonth = october;break;
                    case 11: daysMonth = november;break;
                    case 12: daysMonth = december;break;
                }
                //cái switch ngay trên để đếm số ngày trong tháng
                if(date==13 && year>=yearOfBirth && year<=currentYear){
                    switch ((tuan)%7){
                        case 0:++chia7du0;/*System.out.printf("dư 0  %d-%d-%d\n", date-1, month, year)*/;break;
                        case 1:++chia7du1;/*System.out.printf("dư 1  %d-%d-%d\n", date-1, month, year)*/;break;
                        case 2:++chia7du2;/*System.out.printf("dư 2  %d-%d-%d\n", date-1, month, year)*/;break;
                        case 3:++chia7du3;/*System.out.printf("dư 3  %d-%d-%d\n", date-1, month, year)*/;break;
                        case 4:++chia7du4;/*System.out.printf("dư 4  %d-%d-%d\n", date-1, month, year)*/;break;
                        case 5:++chia7du5;/*System.out.printf("dư 5  %d-%d-%d\n", date-1, month, year)*/;break;
                        case 6:++chia7du6;System.out.printf("Thứ 6  %d-%d-%d\n", date, month, year);break;
                    }
                }//cái này dùng cho việc đếm thứ 6 ngày 13
                if(date==dateOfBirth && month==monthOfBirth && year==yearOfBirth){
                    thuBanSinhRa=(7+(tuan%7))>8?(7+(tuan%7)-7):(7+(tuan%7));
                }//cái này để tính thứ mà bạn lọt lon mẹ ra

                if(year < yearOfBirth && date==1 && month==1){
                    tuan+=(yearCheck==true)?leapYear:normalYear;
                    year+=1;
                }else if(year==yearOfBirth && month<monthOfBirth-1 && date==1){
                    tuan+=daysMonth;
                    month+=1;
                }else /*tách ra từ đây nếu muốn nhiều thứ hay ho*/ if (date < daysMonth) {
                    date += 1;
                    tuan += 1;
                    dayExist+=(year>yearOfBirth || year==yearOfBirth && month>monthOfBirth || year==yearOfBirth && month==monthOfBirth && date>dateOfBirth)?1:0;
                } else if (month < 12) {
                    month += 1;
                    date = 1;
                    tuan += 1;
                    dayExist+=(year>yearOfBirth || year==yearOfBirth && month>monthOfBirth || year==yearOfBirth && month==monthOfBirth && date>dateOfBirth)?1:0;
                } else {
                    date = 1;
                    month = 1;
                    year += 1;
                    tuan += 1;
                    dayExist+=(year>yearOfBirth || year==yearOfBirth && month>monthOfBirth || year==yearOfBirth && month==monthOfBirth && date>dateOfBirth)?1:0;
                }//cái này quan trọng nhất trong cả bài toán
            }while (checkWhile);//quan trọng

            System.out.println("Số ngày bạn tồn tại trên cõi đời này là "+dayExist);

            System.out.print((yearOfBirth % 400==0 || yearOfBirth % 4==0 && yearOfBirth % 100!=0)?"Năm sinh của bạn là năm nhuận":"Năm sinh của bạn éo phải năm nhuận");
            System.out.println((currentYear % 400==0 || currentYear % 4==0 && currentYear % 100!=0)?",Năm hiện tại là năm nhuận":",Năm hiện tại éo phải năm nhuận");

            System.out.println("Ngày bạn sinh ra vào "+((thuBanSinhRa==8)?("Chủ nhật"):("thứ "+thuBanSinhRa)));

            int dayOfTheYear=0;
            switch (currentMonth){
                case 1:dayOfTheYear=currentDate;break;
                case 2:dayOfTheYear=january + currentDate;break;
                case 3:dayOfTheYear=january + (yearCheck==true?februarySpecial:februaryNormal) + currentDate;break;
                case 4:dayOfTheYear=january + (yearCheck==true?februarySpecial:februaryNormal) + march + currentDate;break;
                case 5:dayOfTheYear=january + (yearCheck==true?februarySpecial:februaryNormal) + march + april + currentDate;break;
                case 6:dayOfTheYear=january + (yearCheck==true?februarySpecial:februaryNormal) + march + april + may + currentDate;break;
                case 7:dayOfTheYear=january + (yearCheck==true?februarySpecial:februaryNormal) + march + april + may + june + currentDate;break;
                case 8:dayOfTheYear=january + (yearCheck==true?februarySpecial:februaryNormal) + march + april + may + june + july + currentDate;break;
                case 9:dayOfTheYear=january + (yearCheck==true?februarySpecial:februaryNormal) + march + april + may + june + july + august + currentDate;break;
                case 10:dayOfTheYear=january + (yearCheck==true?februarySpecial:februaryNormal) + march + april + may + june + july + august + september + currentDate;break;
                case 11:dayOfTheYear=january + (yearCheck==true?februarySpecial:februaryNormal) + march + april + may + june + july + august + september + october + currentDate;break;
                case 12:dayOfTheYear=january + (yearCheck==true?februarySpecial:februaryNormal) + march + april + may + june + july + august + september + october + november + currentDate;break;
            }//tính ngày hiện tại là ngày thứ bao nhiêu trong năm
            System.out.println("Ngày hiện tại là ngày thứ "+dayOfTheYear+" trong năm");

            System.out.println("Còn "+(296+ (yearCheck==true?februarySpecial:februaryNormal) - dayOfTheYear)+" ngày là tới ngày 20/11 và "+((yearCheck==true?366:365) - dayOfTheYear)+" là tới tết dương lịch 1/1");

            System.out.println("Số ngày thứ 6 ngày 13 mà bạn có thể đã bỏ lỡ là "+chia7du6);
        }
    }
}