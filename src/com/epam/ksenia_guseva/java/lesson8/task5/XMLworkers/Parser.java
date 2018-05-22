package com.epam.ksenia_guseva.java.lesson8.task5.XMLworkers;

import com.epam.ksenia_guseva.java.lesson8.task5.models.Car;

import java.lang.reflect.Constructor;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by gkseni on 20.05.2018.
 */
public class Parser {

    static final String classPath = "com.epam.ksenia_guseva.java.lesson8.task5.models";
    static final String filePath = "/src/com/epam/ksenia_guseva/java/lesson8/task5";

    public static Car getModelsFromXML(File f, String carName) {
        Car car = null;
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(f);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("car");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) node;

                    if (getText(e, "name").equals(carName)) {
                        String type = getText(e, "type");
                        String color = getText(e, "color");
                        Double fuelConsumption = Parser.parseElement(e, "fuelConsumption");
                        Double cost = Parser.parseElement(e, "cost");
                        String name = Parser.getClassName(carName);

                        Class<?> carClass = Class.forName(carName);
                        Constructor<?> carConstructor = carClass.
                                getDeclaredConstructor(String.class, String.class,
                                        String.class, Double.class, Double.class);

                        car = (Car) carConstructor.newInstance(name, type, color, fuelConsumption, cost);
                    }
                }
            }
        } catch (ParserConfigurationException | NoSuchMethodException |
                ClassNotFoundException | InstantiationException |
                IllegalAccessException | InvocationTargetException |
                IOException | SAXException e) {
            e.printStackTrace();
        }
        return car;
    }

    private static double parseElement(Element e, String name) {
        return Double.parseDouble(Parser.getText(e, name));
    }

    private static String getText(Element e, String name) {
        return e.getElementsByTagName(name).item(0).getTextContent();
    }

    public static String getClassName(String className) {
        return classPath + className;
    }

    public static String getFile(String fileName) {
        return filePath + fileName;
    }
}
