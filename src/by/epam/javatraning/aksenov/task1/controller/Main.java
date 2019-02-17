package by.epam.javatraning.aksenov.task1.controller;

import by.epam.javatraning.aksenov.task1.model.entity.*;
import by.epam.javatraning.aksenov.task1.model.logic.Calculator;
import by.epam.javatraning.aksenov.task1.model.logic.Searcher;
import by.epam.javatraning.aksenov.task1.model.logic.Sorter;
import by.epam.javatraning.aksenov.task1.util.*;
import by.epam.javatraning.aksenov.task1.view.Printable;
import by.epam.javatraning.aksenov.task1.view.PrinterType;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Printable printer = PrinterCreator.create(PrinterType.CONSOLE);

        List<String> list = DataReader.readFile("input/inputFile.txt");
        List<String> validList = DataValidator.getValidString(list);

        EquipmentType[] equipmentTypes = DataConverter.convertStrToEquipmentType(validList);
        Equipment[] equipment = EquipmentCreator.create(equipmentTypes);

        Home home = HomeCreator.create(equipment);


        printer.print(home);
        Sorter.bubbleSortByPower(home);
        printer.print(home);
        double count = Calculator.sumPowerOfDevices(home);
        printer.print(count);
        Equipment e = Searcher.findMaxPowerEquipment(home);
        printer.print(e);

    }
}
