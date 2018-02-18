package com.epam.ksenia_guseva.java.lesson1.task1;

import java.util.Random;
import java.util.Scanner;

/**
 * Guseva Ksenia, Lesson 1, Task 1;
 */


public class Task1 {
    int R_UP = 10, R_DOWN = -10, LENGTH_ARRAY = 20;

    public static void main(String[] args) {
        Task1 app = new Task1();
        app.startTask1();
    }

    public void startTask1(){
        Random r = new Random();

        int[] array = new int[LENGTH_ARRAY];
        for (int i = 0; i < array.length; i++){
            array[i] = r.nextInt(R_UP - R_DOWN) - R_UP;
        }

        System.out.println("Enter number of command, please:");
        System.out.println("1: Change first max negative and min positive\n" +
                           "2: Sum of numbers on even positions\n" +
                           "3: Change negative numbers to zero\n" +
                           "4: Multiply by three all positive numbers under negative\n" +
                           "5: Find difference average and min element\n" +
                           "6: Find numbers on even positions that occur more than once");
        Scanner in = new Scanner(System.in);
        int command = in.nextInt();

        System.out.println("Inital array:");
        printArray(array);
        switch (command){
            case 1:
                printArray(point1(array));
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            default:
                System.out.println("Enter correct command, please");
                break;
        }
    }

    int[] point1(int[] array) {
        int min = R_UP + 1, posMin = 0;
        int max = R_DOWN - 1, posMax = 0;

        for (int i = 0; i < array.length; i++){ //ноль не трогаем
            //минимальный положительный
            if(array[i] > 0 && min > array[i]){
                    min = array[i];
                    posMin = i;
            }
            //максимальный отрицательный
            else if (array[i] < 0 && max < array[i]){
                    max = array[i];
                    posMax = i;
            }
        }

        System.out.println("Change " + min + " on pos " + posMin + " and " + max + " on pos " + posMax);

        array[posMax] = min;
        array[posMin] = max;

        System.out.println("Result array:");
        return array;
    }



    public void printArray(int[] array){
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}


