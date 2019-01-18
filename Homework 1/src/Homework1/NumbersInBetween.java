package Homework1;

import java.util.Scanner;
import java.util.*;
public class NumbersInBetween {
    /**
     * The main method of the class
     * @param args
     * @throws Exception
     */
    public static void main(String []args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the first number");
        int num1 = scanner.nextInt();
        System.out.format("Please enter the second number greater than %d\n", num1);
        int num2 = scanner.nextInt();
        if (!isValidInput(num1, num2)){
            System.out.format("Please enter a number greater than %d \n", num1);
            System.exit(0);
        }
        System.out.format("\nThese are the numbers inbetween \t%d \t and\t %d\n", num1, num2);
        List<Integer> list;
        list = generateNumberBetween(num1, num2);
        printGeneratedNumFromList(list);
    }

    /**
     * this function is used to check if the numbers are valid
     * @param num1 - integer
     * @param num2 - integer
     * @return - boolean - if the number is invalid it returns false else true.
     *                   - eg:- function return false when the second number is less thant he first number.
     */
    public static boolean isValidInput(int num1, int num2){
        if (num2 < num1){
            return false;
        }
        return true;
    }

    /**
     * this function returns a list of all the numbers between the the numbers given by the user
     * @param num1 - integer - value of the first number
     * @param num2 - integer - value of the second number
     * @return - interger list - a list containing all the numbers inbetween.
     */
    public static List<Integer> generateNumberBetween(int num1, int num2){
        List<Integer> list = new ArrayList<>();
        for (int i = num1+1; i<num2; i++){
            list.add(i);
        }
        return list;
    }

    /**
     * function is used to print the odd number from the list.
     * @param list - List<Integer> - list containing the numbers.
     */
    public static void printGeneratedNumFromList(List<Integer> list){
        for (int i:list) {
            if (i%2 !=0){
                System.out.println(i);
            }
        }
    }
}
