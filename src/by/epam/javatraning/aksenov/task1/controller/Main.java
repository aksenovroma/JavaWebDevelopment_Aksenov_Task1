package by.epam.javatraning.aksenov.task1.controller;

import by.epam.javatraning.aksenov.task1.model.entity.*;
import by.epam.javatraning.aksenov.task1.model.logic.Sorter;
import by.epam.javatraning.aksenov.task1.util.DataReader;
import by.epam.javatraning.aksenov.task1.util.DataValidator;
import by.epam.javatraning.aksenov.task1.util.PrinterCreator;
import by.epam.javatraning.aksenov.task1.view.Printable;
import by.epam.javatraning.aksenov.task1.view.PrinterType;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Lamp lamp1 = new Lamp(100, 20, true, 3);
        Lamp lamp2 = new Lamp(50, 20, true, 1);
        Microwave microwave = new Microwave(1000, 550, true, 15.3);
        Television television = new Television(1500, 300, false, 20.5);

        Equipment[] equipment = {lamp1, lamp2, microwave, television};

        Home home = new Home(lamp1);

        Printable printer = PrinterCreator.create(PrinterType.CONSOLE);



    }
}
