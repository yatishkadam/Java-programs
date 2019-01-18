package Homework1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class NumbersInBetweenTest {

    @Test
    public void generateNumberBetweenTest() {
        int num1 = 2;
        int num2 = 5;
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        assertEquals(list, NumbersInBetween.generateNumberBetween(num1, num2));
    }

    @Test
    public void isValidInputTest(){
        int num1 = 1;
        int num2 = 3;
        assertFalse(!NumbersInBetween.isValidInput(num1, num2));

    }

    @Test
    public void printNumberBetweenTest(){
        int num1 = 1;
        int num2 = 9;
        List<Integer> list = new ArrayList<>();
        List<Integer> listNumber = new ArrayList<>();
        List<Integer> listOdd = new ArrayList<>();
        list.add(3);
        list.add(5);
        list.add(7);
        listNumber = NumbersInBetween.generateNumberBetween(num1, num2);
        for (int i:listNumber) {
            if (i%2 !=0){
                listOdd.add(i);
            }
        }
        assertEquals(list, listOdd);
    }

    @Test
    public void printEvenNumberBetweenTest(){
        int num1 = 1;
        int num2 = 9;
        List<Integer> list = new ArrayList<>();
        List<Integer> listNumber = new ArrayList<>();
        List<Integer> listOdd = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(8);
        listNumber = NumbersInBetween.generateNumberBetween(num1, num2);
        for (int i:listNumber) {
            if (i%2 ==0){
                listOdd.add(i);
            }
        }
        assertEquals(list, listOdd);
    }

}