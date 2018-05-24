package com.epam.ksenia_guseva.java.lesson8.XMLWorkers;

import com.epam.ksenia_guseva.java.lesson8.models.Car;
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
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class XMLParser {
    public static Car getCarFromXML(File f, String carName) {
        Car car = null;

        try {

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            Document document = documentBuilder.parse(f);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("cars");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element e = (Element) node;

                    if (getString(e, "name").equals(carName)) {

                        String type = XMLParser.getString(e, "type");
                        String color = XMLParser.getString(e, "color");
                        Double fuelConsumption = XMLParser.parseDouble(e, "fuelConsumption");
                        Double cost = XMLParser.parseDouble(e, "cost");

                        String nameOfCar = Helper.getClassPath(carName);

                        Class<?> carClass = Class.forName(nameOfCar);
                        Constructor<?> constructor = carClass.getDeclaredConstructor(String.class, String.class,
                                Double.class, Double.class);

                        car = (Car) constructor.newInstance(type, color, fuelConsumption, cost);
                    }
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException | ClassNotFoundException
                | NoSuchMethodException | IllegalAccessException | InvocationTargetException |
                InstantiationException e) {
            e.printStackTrace();
        }

        return car;
    }

    private static String getString(Element e, String tag) {
        return  e.getElementsByTagName(tag).item(0).getTextContent();
    }

    private static Double parseDouble(Element e, String tag) {
        return Double.parseDouble(XMLParser.getString(e, tag));
    }
}
