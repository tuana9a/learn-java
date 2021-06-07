package com.tuana9a.other;

import java.util.Scanner;
import java.util.Stack;

public class Calculator {
    private static final Scanner input = new Scanner(System.in);
    private static final char mul = '*', div = '/', add = '+', sub = '-';

    private static int higherPriority(char x, char y) {
        if ((x == mul || x == div) && (y == add || y == sub)) return 1;
        if ((y == mul || y == div) && (x == add || x == sub)) return -1;
        if (x == '(' || y == '(') return -1;
        return 0;
    }

    public static void eval() {
        System.out.println("input the operation:");
        String inputString = input.nextLine();
        inputString = inputString.replaceAll("\\s+","");
        inputString += ")";
        char[] inputCharArray = inputString.toCharArray();
        Stack<Character> characterStack = new Stack<Character>();
        characterStack.push('(');
        StringBuilder result = new StringBuilder();
        for (char c : inputCharArray) {
            if (Character.isDigit(c)) {
                result.append(c);
                continue;
            }
            if (c == '(') {
                characterStack.push(c);
                continue;
            }
            if (c == ')') {
                while (characterStack.peek() != '(') {
                    result.append(characterStack.pop());
                }
                characterStack.pop();
                continue;
            }
            while (higherPriority(characterStack.peek(), c) >= 0) {
                result.append(characterStack.pop());
            }
            characterStack.push(c);
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        while (true) {
            eval();
        }
    }
}
