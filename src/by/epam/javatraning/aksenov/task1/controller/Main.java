package by.epam.javatraning.aksenov.task1.controller;

import by.epam.javatraning.aksenov.task1.model.container.ArrayQueue;
import by.epam.javatraning.aksenov.task1.model.container.ArrayStack;
import by.epam.javatraning.aksenov.task1.model.container.ListQueue;
import by.epam.javatraning.aksenov.task1.model.container.ListStack;
import by.epam.javatraning.aksenov.task1.model.entity.*;
import by.epam.javatraning.aksenov.task1.model.exception.TechnicalProjectException;
import by.epam.javatraning.aksenov.task1.model.logic.Calculator;
import by.epam.javatraning.aksenov.task1.model.logic.Searcher;
import by.epam.javatraning.aksenov.task1.model.logic.Sorter;
import by.epam.javatraning.aksenov.task1.util.*;
import by.epam.javatraning.aksenov.task1.util.data.DataConverter;
import by.epam.javatraning.aksenov.task1.util.data.DataReader;
import by.epam.javatraning.aksenov.task1.util.data.DataValidator;
import by.epam.javatraning.aksenov.task1.util.entitycreator.EquipmentCreator;
import by.epam.javatraning.aksenov.task1.util.entitycreator.HomeCreator;
import by.epam.javatraning.aksenov.task1.util.exception.EmptyFileException;
import by.epam.javatraning.aksenov.task1.util.exception.NoValidStringException;
import by.epam.javatraning.aksenov.task1.view.Printable;
import by.epam.javatraning.aksenov.task1.view.PrinterType;

import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Program implements the hierarchy of electrical equipment in the house.
 * <p>
 * https://github.com/aksenovroma/JavaWebDevelopment_Aksenov_Task1
 *
 * @author aksenov
 * @version 1.0
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("input file name: ");

        String filename = UserInput.inputString();
        List<String> list = null;

        try {
            list = DataReader.readFile("input/" + filename);
        } catch (EmptyFileException e) {
            System.out.println(e.getMessage());
        }

        List<String> validList = null;

        try {
            validList = DataValidator.getValidString(list);
        } catch (NoValidStringException e) {
            System.out.println(e.getMessage());
        }

        EquipmentType[] equipmentTypes = DataConverter.strToEquipmentType(validList);
        Equipment[] equipment = EquipmentCreator.create(equipmentTypes);

        Home home = HomeCreator.create(equipment);

        PrinterType printerType = UserPrinter.select();
        Printable printer = PrinterCreator.create(printerType);

        printer.print(home);
        Sorter.bubbleSortByPower(home);
        printer.print(home);
        double count = Calculator.sumPowerOfDevices(home);
        printer.print(count);
        Equipment e = Searcher.findMaxPowerEquipment(home);
        printer.print(e);

    }
}
