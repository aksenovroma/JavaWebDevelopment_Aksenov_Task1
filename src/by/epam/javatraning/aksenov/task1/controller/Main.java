package by.epam.javatraning.aksenov.task1.controller;

import by.epam.javatraning.aksenov.task1.model.entity.*;
import by.epam.javatraning.aksenov.task1.model.logic.Calculator;
import by.epam.javatraning.aksenov.task1.model.logic.Searcher;
import by.epam.javatraning.aksenov.task1.model.logic.Sorter;
import by.epam.javatraning.aksenov.task1.util.*;
import by.epam.javatraning.aksenov.task1.util.data.DataParser;
import by.epam.javatraning.aksenov.task1.util.data.DataReader;
import by.epam.javatraning.aksenov.task1.util.data.DataValidator;
import by.epam.javatraning.aksenov.task1.util.entitycreator.EquipmentCreator;
import by.epam.javatraning.aksenov.task1.util.entitycreator.HomeCreator;
import by.epam.javatraning.aksenov.task1.util.exception.EmptyFileException;
import by.epam.javatraning.aksenov.task1.util.exception.NoValidStringException;
import by.epam.javatraning.aksenov.task1.view.Printable;
import by.epam.javatraning.aksenov.task1.view.PrinterType;

import java.util.List;

/**
 * Program implements the hierarchy of electrical equipment in the house.
 * <p>
 * https://github.com/aksenovroma/JavaWebDevelopment_Aksenov_Task1
 *
 * @author aksenov
 * @version 1.0
 */

public class Main {
    private static final String INPUT_FILE = "input/inputTestFile1.txt";
    private static final String OUTPUT_FILE = "output/outputFile.txt";

    public static void main(String[] args) {
        String text = null;

        try {
             text = DataReader.readFile(INPUT_FILE);
        } catch (EmptyFileException e) {
            e.printStackTrace();
        }

        List<String> validList = null;

        try {
            validList = DataValidator.getValidString(text);
        } catch (NoValidStringException e) {
            e.printStackTrace();
        }

/*        EquipmentType[] equipmentTypes = DataParser.strToEquipmentType(validList);
        Equipment[] equipment = EquipmentCreator.create(equipmentTypes);

        Home home = HomeCreator.create(equipment);

        PrinterType printerType = UserPrinter.select(OUTPUT_FILE);
        Printable printer = PrinterCreator.create(printerType);

        printer.print(home);
        Sorter.bubbleSortByPower(home);
        printer.print(home);
        double count = Calculator.sumPowerOfDevices(home);
        printer.print(count);
        Equipment e = Searcher.findMaxPowerEquipment(home);
        printer.print(e);*/

    }
}
