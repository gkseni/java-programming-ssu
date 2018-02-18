package com.epam.ksenia_guseva.java.lesson1.task1;

import java.util.Random;
import java.util.Scanner;

/**
 * Guseva Ksenia, Lesson 1, Task 1;
 */


public class Task1 {
    int R_UP = 10, R_DOWN = -10, LENGTH_ARRAY = 20;
    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Task1 app = new Task1();
        app.startTask1();
    }

    public void startTask1() {
        Random r = new Random();

        int[] array = new int[LENGTH_ARRAY];
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(R_UP - R_DOWN) - R_UP;
        }

        System.out.println("Enter number of command, please:");
        System.out.println("1: Change first max negative and min positive\n" +
                "2: Sum of numbers on even positions\n" +
                "3: Change negative numbers to zero\n" +
                "4: Multiply by three all positive numbers under negative\n" +
                "5: Find difference of average and min element\n" +
                "6: Find numbers on even positions that occur more than once");

        int command = in.nextInt();

        System.out.println("Inital array:");
        printArray(array);
        switch (command) {
            case 1:
                printArray(point1(array));
                break;
            case 2:
                point2(array);
                break;
            case 3:
                printArray(point3(array));
                break;
            case 4:
                printArray(point4(array));
                break;
            case 5:
                point5(array);
                break;
            case 6:
                point6(array);
                break;
            default:
                System.out.println("Enter correct command, please");
                break;
        }
    }

    int[] point1(int[] array) {
        int min = R_UP, posMin = 0;
        int max = R_DOWN, posMax = 0;

        for (int i = 0; i < array.length; i++) {
            //min positive
            if (array[i] > 0 && min > array[i]) {
                min = array[i];
                posMin = i;
            }
            //max negative
            else if (array[i] < 0 && max < array[i]) {
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

    void point2(int[] array) {
        System.out.println("Result:");
        int sum = 0;
        for (int i = 0; i < array.length; i += 2) {
            System.out.print((i + 2 < array.length) ? (array[i] + " + ") : array[i]);
            sum += array[i];
        }
        System.out.println(" = " + sum);
    }

    int[] point3(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                array[i] = 0;
            }
        }

        System.out.println("Result array:");
        return array;
    }

    int[] point4(int[] array) {
        System.out.print("Change number ");
        for (int i = 1; i < array.length; i++) {
            if (array[i] < 0 && array[i - 1] > 0) {
                System.out.print(array[i - 1] + " on pos " + (i - 1) + ", ");
                array[i - 1] *= 3;
            }
        }

        System.out.println("result array:");
        return array;
    }

    void point5(int[] array) {
        int sum = 0, min = R_UP;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (min > array[i]) {
                min = array[i];
            }
        }

        int average = sum / array.length, result = Math.abs(average - min);

        System.out.println("Difference of average (" + average + ") and min element (" + min + ") is " + result);
    }

    void point6(int[] array) {
        // берет элемент, проверяет есть ли такие же дальше,
        // попутно заменяя одинаковый элемент на маркер, чтобы не было повторений на выходе,
        // подсчитывая количество таких элементов
        // и запоминая, был ли элемент на нечетной позиции
        // (маркер - число, не входящее в диапазон доступных значений)
        System.out.print("The numbers are ");
        for (int i = 0; i < array.length; i++) {
            int cnt = 0;
            boolean wasEven = false;
            if (array[i] != R_UP + 1) {
                for (int j = i + 1; j < array.length; j++) {
                    if (array[j] == array[i]) {
                        cnt++;
                        array[j] = R_UP + 1;
                        if (j % 2 == 1) {
                            wasEven = true;
                        }
                    }
                }
                if (cnt > 0 && (wasEven || i % 2 == 1)) {
                    System.out.print(array[i] + " ");
                }
                array[i] = R_UP + 1;
            }
//            printArray(array);
        }
    }

    public void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}


