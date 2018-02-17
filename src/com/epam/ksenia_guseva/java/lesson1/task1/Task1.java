package com.epam.ksenia_guseva.java.lesson1.task1;

import java.util.Random;

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
        for (int i = 0; i < LENGTH_ARRAY; i++){
            array[i] = r.nextInt(R_UP - R_DOWN) - R_UP;
        }

        print(array);
        print(point1(array));
        print(array);

    }

    int[] point1(int[] array) {
        int min = R_UP + 1, posMin = 0;
        int max = R_DOWN - 1, posMax = 0;

        for (int i = 0; i < LENGTH_ARRAY; i++){ //ноль не трогаем
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

        array[posMax] = min;
        array[posMin] = max;

        return array;
    }

    public void print(int[] array){
        for (int i = 0; i < LENGTH_ARRAY; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}


