package com.epam.ksenia_guseva.java.lesson8.XMLWorkers;

public class Helper {

    private static final String filePath = "src/com/epam/ksenia_guseva/java/lesson8/";
    private static final String classPath ="com.epam.ksenia_guseva.java.lesson8.models";

    public static String getFilePath(String fName) {
        return Helper.filePath + fName;
    }

    public static String getClassPath(String cName) {
        return Helper.classPath + cName;
    }
}
