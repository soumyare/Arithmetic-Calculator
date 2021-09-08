package com;
import java.util.InputMismatchException;
import java.util.Scanner;

public class calculator {

    //the next 4 functions contain the functionality of the arithmetic calculations, they are called by the switch statement branches
    private static double add(double f, double s){
        return f+s;
    }
    private static double subtract(double f, double s){
        return f-s;
    }
    private static double multiply(double f, double s){
        return f*s;
    }
    private static double divide(double f, double s){
        return f/s;
    }

    //this prompt asks the user what numbers they want to perform operations on and stores them in an aarry of doubles
    private static double[] prompt(Scanner s)
    {
        try
        {
            System.out.println("Please input your first number");
            double first = s.nextDouble();
            System.out.println("Please input your second number");
            double second = s.nextDouble();

            return new double[]{first, second};
        } catch (InputMismatchException e)
        {
            System.out.println("You entered an invalid number");
        };
        return null;
    }

    public static void main(String[] args){
        boolean running = true; //remains true until user types "quit"

        Scanner s;
        while(running)
        {
            System.out.println("Please enter the operation you would like to perform (add, subtract, multiply, divide) \nType 'quit' to quit");
            s = new Scanner(System.in);
            String userInput = s.nextLine().toLowerCase(); // sets to lower to account for lowercase

            //switch statement has branches for the 4 operations and quit, if the input is something else they will be asked to enter a valid input
            switch(userInput)
            {
                case "add":
                    double[] aryAdd = prompt(s);
                    System.out.println("\nResult: " + aryAdd[0] + " + " + aryAdd[1] + " = " + add(aryAdd[0], aryAdd[1]) + "\n");
                    break;
                case "subtract":
                    double[] arySub = prompt(s);
                    System.out.println("\nResult: " + arySub[0] + " - " + arySub[1] + " = " + subtract(arySub[0], arySub[1]) + "\n");
                    break;
                case "multiply":
                    double[] aryMul = prompt(s);
                    System.out.println("\nResult: " + aryMul[0] + " * " + aryMul[1] + " = " + multiply(aryMul[0], aryMul[1]) + "\n");
                    break;
                case "divide":
                    double[] aryDiv = prompt(s);
                    System.out.println("\nResult: " + aryDiv[0] + " / " + aryDiv[1] + " = " + divide(aryDiv[0], aryDiv[1]) + "\n");
                    break;
                case "quit":
                    running = false;
                    break;
                default:
                    System.out.println("Please enter a valid operation (add, subtract, multiply, divide)");
                    break;
            }
        }
    }
}