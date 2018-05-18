package com.epam.ksenia_guseva.java.lesson3;

import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

            Student student_1 = new Student("Ivan", "Ivanov", "J2EE Developer", simpleDateFormat.parse("1.05.2018"));
            Student student_2 = new Student("Petr", "Petrov", "Java Developer", simpleDateFormat.parse("18.05.2018"));
            
            Course javaServletsCourse = new Course("Технология Java Servlets", 16);
            Course strutsFrameworkCourse = new Course("Struts Framework", 24);
            Course javaTechnologiesCourse = new Course("Обзор технологий Java", 8);
            Course JFCLibraryCourse = new Course("Библиотека JFC/Swing", 16);
            Course JDBCTechnologyCourse = new Course("Технология JDBC", 16);
            
            student_1.addCourse(javaServletsCourse);
            student_1.addCourse(strutsFrameworkCourse);

            student_2.addCourse(javaTechnologiesCourse);
            student_2.addCourse(JFCLibraryCourse);
            student_2.addCourse(JDBCTechnologyCourse);
            
            StudyCenter center = new StudyCenter();
            center.addStudent(student_1);
            center.addStudent(student_2);

            Scanner sc = new Scanner(System.in);
            System.out.println("Введите 0 для сокращенного отчета, 1 для полного:");

            int choice = sc.nextInt();
            center.printReport(choice != 0);

            sc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
