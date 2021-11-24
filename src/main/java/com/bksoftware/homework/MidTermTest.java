package com.bksoftware.homework;

import java.util.Scanner;

public class MidTermTest {
    static Scanner input = new Scanner(System.in);
    private static Object InputStreamHook;

    public static void main(String[] args) {
        System.out.println(correctName());
        System.out.println(checkPassWord());
        System.out.println(checkPhoneNumber());
        System.out.println(checkEmail());
        System.out.println(waterFee());
        System.out.println(electricFee());
    }

    public static boolean checkEmail() {
        System.out.println("Type in your Email (all must normal case, letters(a-z), numbers(0-9), dashed,s dots are allowed");
        String in = input.nextLine();
        String localPart = "";
        String domainName = "";
        int atCheck = 0;
        //------------------------------------------------------------------------------------------------------
        for (int i = 0; i < in.length(); ++i) {
            if (in.charAt(i) == '@') ++atCheck;
            if (atCheck > 1)
                return false;                                                        //case that has more than 1 At character
            if (Character.isSpaceChar(in.charAt(i))) return false;                   //case that has Space character
            if (Character.isUpperCase(in.charAt(i))) return false;
            if (atCheck == 0) {
                localPart = localPart.concat(Character.toString(in.charAt(i)));
            } else {
                domainName = domainName.concat(Character.toString(in.charAt(i)));
            }
        }
        //------------------------------------------------------------------------------------------------------
        domainName = domainName.replace("@", "");//cut off At character at start of domainName
        if (domainName.length() == 0 || localPart.length() == 0)
            return false;                                                            //case that doesn't have At character
        //System.out.println(localPart + "|" + domainName);
        //------------------------------------------------------------------------------------------------------

        for (int i = 0; i < localPart.length(); ++i) {
            if (!Character.isLetter(localPart.charAt(i)) && !Character.isDigit(localPart.charAt(i))) {
                if (i == localPart.length() - 1 || i == 0)
                    return false;                           //case that have special character at the end or start of localPart
                if (localPart.charAt(i) == '_' || localPart.charAt(i) == '.' || localPart.charAt(i) == '-') {
                    if (!Character.isLetter(localPart.charAt(i + 1)) && !Character.isDigit(localPart.charAt(i + 1)))
                        return false;
                    //case that don't have normal character after a special character
                } else {
                    return false;                                                   //case that don't match any special character
                }
            }
        }
        int lastDotDomainName = domainName.lastIndexOf('.');
        if (lastDotDomainName > domainName.length() - 3 || lastDotDomainName == 0 || lastDotDomainName == -1)
            return false;
        for (int i = 0; i < domainName.length(); ++i) {
            if (!Character.isLetter(domainName.charAt(i)) && !Character.isDigit(domainName.charAt(i))) {
                if (i == domainName.length() - 1 || i == 0)
                    return false;                           //case that have special character at the end or start of domainName
                if (domainName.charAt(i) == '.' || domainName.charAt(i) == '-') {
                    if (!Character.isLetter(domainName.charAt(i + 1)) && !Character.isDigit(domainName.charAt(i + 1)))
                        return false;
                    //case that don't have normal character after a special character
                } else {
                    return false;                                                   //case that don't match any special character
                }
            }
        }
        return true;
    }

    public static String correctName() {
        System.out.println("Type in your name");
        String inputString = input.nextLine();
        inputString = inputString.trim();
        String result = "";
        result = inputString.replaceAll("\\s+", " ");
        return result;
    }

    public static boolean checkPassWord() {
        System.out.println("Type in your Password");
        String in = input.nextLine();
        System.out.println("inString is: \"" + in + "\"");
        if (in.length() < 8) return false;
        int numCount = 0;
        int specialChar = 0;
        for (int i = 0; i < in.length(); ++i) {
            if (Character.isDigit(in.charAt(i))) ++numCount;
            if (!Character.isDigit(in.charAt(i)) && !Character.isLetter(in.charAt(i))) ++specialChar;
        }
        if (numCount == 0 || specialChar == 0) return false;
        return true;
    }

    public static boolean checkThreeFirstNumber(String in, int kind) {
        if (in.charAt(kind + 1) == '3') {
            for (int i = 2; i <= 9; ++i) {
                if ((int) in.charAt(kind + 2) == i + (int) ('0')) return true;
            }
        }
        if (in.charAt(kind + 1) == '5') {
            switch (in.charAt(kind + 2)) {
                case '6':
                    return true;
                case '8':
                    return true;
            }
        }
        if (in.charAt(kind + 1) == '7') {
            switch (in.charAt(kind + 2)) {
                case '0':
                    return true;
                case '9':
                    return true;
                case '7':
                    return true;
                case '6':
                    return true;
                case '8':
                    return true;
            }
        }
        if (in.charAt(kind + 1) == '8') {
            switch (in.charAt(kind + 2)) {
                case '8':
                    return true;
                case '1':
                    return true;
                case '2':
                    return true;
                case '3':
                    return true;
                case '4':
                    return true;
                case '5':
                    return true;
            }
        }
        if (in.charAt(kind + 1) == '9') {
            switch (in.charAt(kind + 2)) {
                case '1':
                    return true;
                case '4':
                    return true;
                case '2':
                    return true;
                case '9':
                    return true;
                case '6':
                    return true;
                case '7':
                    return true;
                case '8':
                    return true;
                case '0':
                    return true;
                case '3':
                    return true;
            }
        }
        return false;
    }

    public static boolean checkPhoneNumber() {
        System.out.println("Type in Phone number:(\"+84\" start or \"00\" start for national calling (required) or just type in your local number)");
        String in = input.nextLine();
        if (in.length() != 10 && in.length() != 12 && in.length() != 11 && in.length() != 3) return false;
        if (in.length() == 12) {
            if (in.charAt(0) != '+') return false;
            if (in.charAt(1) != '8') return false;
            if (in.charAt(2) != '4') return false;
            if (checkThreeFirstNumber(in, 2)) return true;
        }
        if (in.length() == 11) {
            if (in.charAt(0) != '0') return false;
            if (in.charAt(1) != '0') return false;
            if (checkThreeFirstNumber(in, 1)) return true;
        }
        if (in.length() == 10) {
            if (in.charAt(0) != '0') return false;
            if (checkThreeFirstNumber(in, 0)) return true;
        }
        if (in.length() == 3) {
            if (in.charAt(0) == '1') {
                if (in.charAt(1) == '0') {
                    if (in.charAt(2) == '1') return true;
                    return false;
                }
                if (in.charAt(1) == '1') {
                    if (in.charAt(2) == '7') return false;
                    return true;
                }
            }
        }
        return false;
    }

    public static long waterFee() {
        System.out.println("Type in your water usage");
        double fee = 0;
        int num = input.nextInt();
        fee = num * 6095;
        if (num > 4) fee = 4 * 6095 + (num - 4) * 11730;
        if (num > 6) fee = 4 * 609 + 2 * 11730 + (num - 6) * 13110;
        return Math.round(fee);
    }

    public static long electricFee() {
        System.out.println("Type in your electric usage");
        double fee = 0;
        int num = input.nextInt();
        fee = num * 1549;
        if (num > 50) fee = 50 * 1549 + (num - 50) * 1600;
        if (num > 100) fee = 50 * 1549 + 50 * 1600 + (num - 100) * 1858;
        if (num > 200) fee = 50 * 1549 + 50 * 1600 + 100 * 1858 + (num - 200) * 234;
        if (num > 300) fee = 50 * 1549 + 50 * 1600 + 100 * 1858 + 100 * 234 + (num - 300) * 2615;
        if (num > 400) fee = 50 * 1549 + 50 * 1600 + 100 * 1858 + 100 * 234 + 100 * 2615 + (num - 400) * 2701;
        return Math.round(fee);
    }
}
