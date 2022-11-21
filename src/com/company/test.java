package com.company;

import java.util.*;

public class test{

    public static int Calculator(String equation){
        Stack<Integer> stack = new Stack<>();

        int sum = 0;
        int number = 0;
        Character sign = '+';
        boolean exist_sign = true;

        for (int i = 0; i < equation.length(); i++) {

            Character ch = equation.charAt(i);

            if (Character.isDigit(ch)) {
                number = Integer.parseInt(String.valueOf(ch));

                if (i + 1 != equation.length() && Character.isDigit(equation.charAt(i + 1))) {
                    //in the case if it is more than 9
                    number = number * 10 + Integer.parseInt(String.valueOf(equation.charAt(i + 1)));

                }
            }

            else if (ch == '-' || ch == '/' || ch == '*' || ch == '+'){
                if (exist_sign){ //as an example: 2++2, 3+/1
                    System.out.println("Two operators in raw is not correct");
                    System.exit(0);
                }

                exist_sign = true;
                sign = ch;
                continue;
            }

            else{
                System.out.println("The input is not correct, Try again...");
                System.exit(1);

            }


            if (exist_sign) {
                switch (sign) {
                    case '-':
                        stack.push(-number);
                        break;
                    case '+':
                        stack.push(number);
                        break;
                    case '*':
                        stack.push(stack.pop() * number);
                        break;
                    case '/':
                        stack.push(stack.pop()/number);
                        break;
                }
                exist_sign = false;
            }

        }

        for (int elem : stack) {
            sum += elem;
        }

        return sum;
    }
    public static void main(String[] args){
        System.out.println("2 + 40 / 2 = " + Calculator("2+40/2"));
    }

}
