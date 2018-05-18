package com.epam.ksenia_guseva.java.lesson3;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class StudyCenter {
    private List<Student> students;

    public StudyCenter() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void printReport(boolean isDetailed) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat simpleHourFormat = new SimpleDateFormat("HH");
        Date currentDate = new Date();

        for (Student student : this.students) {
            StringBuilder nameStudent = new StringBuilder();
            nameStudent.append("Студент: " + student.getFirstName() + " " + student.getSecondName());

            StringBuilder nameCourse = new StringBuilder();
            nameCourse.append("Название курса: ").append(student.getStudyCourse());

            StringBuilder durationCourse = new StringBuilder();
            int durationOfCourse = student.courses.stream()
                    .map(new Function<Course, Integer>() {
                        public Integer apply(Course course) {
                            return course.duration;
                        }
                    })
                    .reduce(0, new BinaryOperator<Integer>() {
                        public Integer apply(Integer a, Integer b) {
                            return a + b;
                        }
                    });
            int daysOfCourse = durationOfCourse / 8;
            int hoursOfCourse = durationOfCourse % 8;
            durationCourse.append("Длительность программы в часах: ").append(durationOfCourse);

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(student.startDate);
            int addDays = daysOfCourse;
            if (hoursOfCourse != 0) {
                addDays++;
            }
            calendar.add(Calendar.DAY_OF_MONTH, addDays - 1);
            Date finishDate = calendar.getTime();

            StringBuilder startDateCourse = new StringBuilder();
            startDateCourse.append("Дата старта: ").append(simpleDateFormat.format(student.startDate));

            StringBuilder finishDateCourse = new StringBuilder();
            finishDateCourse.append("Дата окончания: ").append(simpleDateFormat.format(finishDate));

            StringBuilder overOrNot = new StringBuilder();
            long differenceBetweenDates = currentDate.getTime() - student.startDate.getTime();
            int passedDays = (int) (differenceBetweenDates / (24 * 60 * 60 * 1000));
            int passedHours = Integer.parseInt(simpleHourFormat.format(currentDate));
            overOrNot.append(isCoursesEnded(passedDays, daysOfCourse, passedHours, hoursOfCourse) ?
                    "Обучение закончено. " : "Обучение не закончено. ");

            StringBuilder laterOrLeft = new StringBuilder();
            if (isCoursesEnded(passedDays, daysOfCourse, passedHours, hoursOfCourse)) {
                int laterDays = passedDays - daysOfCourse,
                        laterHours = Math.min(18, passedHours) - (hoursOfCourse + 10);

                laterOrLeft.append("После окончания прошло ").append(laterDays).append(" д ")
                        .append(laterHours).append(" ч.");
            } else {
                int leftDays = daysOfCourse - passedDays;
                if (passedHours >= 18) leftDays--;
                int leftHours = (hoursOfCourse + 10) - Math.min(10, Math.max(10, passedHours));

                laterOrLeft.append("До окончания осталось ").append(leftDays).append(" д ")
                        .append(leftHours).append(" ч.");
            }

            System.out.println(!isDetailed ? (nameStudent + "\n" + nameCourse + "\n" + overOrNot + laterOrLeft + "\n") :
                    (nameStudent + "\n" + nameCourse + "\n" + durationCourse + "\n" +
                            startDateCourse + "\n" + finishDateCourse + "\n" + overOrNot + laterOrLeft + "\n"));
        }
    }

    private boolean isCoursesEnded(int passedDays, int daysOfCourse, int passedHours, int hoursOfCourse) {
        return passedDays > daysOfCourse || (passedDays == daysOfCourse && passedHours >= hoursOfCourse + 10);
    }
}
