package com.epam.ksenia_guseva.java.lesson1.task2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Guseva Ksenia, Lesson 1, Task 2;
 */
public class Task2 {
    public static void main(String[] args) {
        Task2 app = new Task2();
        app.startTask2();
    }

    public void startTask2() {
        System.out.println("Enter number of strings:");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        System.out.println("Enter n strings:");
        ArrayList<String> strings = new ArrayList<>();
        int averageLength = 0;
        for (int i = 0; i < n; i++) {
            String nextString = in.nextLine();
            strings.add(nextString);

            averageLength += strings.get(i).length();
        }
        averageLength /= n;

        System.out.println("Enter number of command, please:");
        System.out.println("1: Print strings with length\n" +
                "2: Print strings of more then average length\n" +
                "3: Print strings of less then average length\n" +
                "4: Print first string with minimum different symbols\n" +
                "5: Print string with all different symbols\n" +
                "6: Print (second) string with numbers only");

        int command = in.nextInt();
        switch (command) {
            case 1:
                int min = strings.get(0).length(), max = strings.get(0).length();
                String minString = strings.get(0), maxString = strings.get(0);
                for (int i = 0; i < n; i++) {
                    if (strings.get(i).length() < min) {
                        min = strings.get(i).length();
                        minString = strings.get(i);
                    }

                    if (strings.get(i).length() > max) {
                        max = strings.get(i).length();
                        maxString = strings.get(i);
                    }
                }

                System.out.println("Min string is \"" + minString + "\" length of " + min);
                System.out.println("Max string is \"" + maxString + "\" length of " + max);
                break;
            case 2:
                System.out.println("Average length is " + averageLength);

                for (int i = 0; i < n; i++) {
                    if (strings.get(i).length() > averageLength) {
                        System.out.println("\"" + strings.get(i) + "\" of length " + strings.get(i).length());
                    }
                }

                break;
            case 3:
                System.out.println("Average length is " + averageLength);

                for (int i = 0; i < n; i++) {
                    if (strings.get(i).length() < averageLength) {
                        System.out.println("\"" + strings.get(i) + "\" of length " + strings.get(i).length());
                    }
                }

                break;
            case 4:
                int minDifCnt = strings.get(0).length();
                String minDifString = strings.get(0);
                for (int i = 0; i < n; i++) {
                    String difSymbols = "";
                    String symbol;
                    for (int j = 0; j < strings.get(i).length(); j++) {
                        symbol = String.valueOf(strings.get(i).charAt(j));
                        if (!difSymbols.contains(symbol))
                            difSymbols += symbol;
                    }

                    System.out.println(difSymbols);

                    if (minDifCnt > difSymbols.length()) {
                        minDifCnt = difSymbols.length();
                        minDifString = strings.get(i);
                    }
                }
                System.out.println("\"" + minDifString + "\" of length " + minDifCnt);

                break;
            case 5:
                for (int i = 0; i < n; i++) {
                    String difSymbols = "";
                    String symbol;
                    for (int j = 0; j < strings.get(i).length(); j++) {
                        symbol = String.valueOf(strings.get(i).charAt(j));
                        if (!difSymbols.contains(symbol))
                            difSymbols += symbol;
                    }

                    if (difSymbols.length() == strings.get(i).length()){
                        System.out.println(strings.get(i));
                        break;
                    }
                }

                break;
            case 6:
                ArrayList<String> numStrs = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    if (strings.get(i).matches("\\d+")) {
                        numStrs.add(strings.get(i));
                    }
                }

                System.out.println(numStrs.get(numStrs.size() > 1 ? 1 : 0));
                break;
            default:
                System.out.println("Enter correct command, please");
                break;
        }

    }
}
