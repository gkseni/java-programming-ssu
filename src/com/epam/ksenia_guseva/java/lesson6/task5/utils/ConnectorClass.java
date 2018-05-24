package com.epam.ksenia_guseva.java.lesson6.task5.utils;

import java.io.*;

public class ConnectorClass {

    public static void addObjectToFile(File f, Object o) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(f))){
            objectOutputStream.writeObject(o);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object readObjectFromFile(File f) {
        Object rObj = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(f))) {
            rObj = objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return rObj;
    }

}
