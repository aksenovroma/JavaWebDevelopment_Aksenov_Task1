package by.epam.javatraning.aksenov.task1.controller;

import by.epam.javatraning.aksenov.task1.model.entity.*;
import by.epam.javatraning.aksenov.task1.model.entity.container.Home;
import by.epam.javatraning.aksenov.task1.model.entity.container.HomeArray;
import by.epam.javatraning.aksenov.task1.model.exception.logic.HomeEquipmentWrongException;
import by.epam.javatraning.aksenov.task1.model.logic.Calculator;
import by.epam.javatraning.aksenov.task1.model.logic.Searcher;
import by.epam.javatraning.aksenov.task1.model.logic.Sorter;
import by.epam.javatraning.aksenov.task1.util.*;
import by.epam.javatraning.aksenov.task1.util.data.DataParser;
import by.epam.javatraning.aksenov.task1.util.data.DataReader;
import by.epam.javatraning.aksenov.task1.util.data.DataValidator;
import by.epam.javatraning.aksenov.task1.util.entitycreator.EquipmentCreator;
import by.epam.javatraning.aksenov.task1.util.entitycreator.HomeArrayCreator;
import by.epam.javatraning.aksenov.task1.util.entitycreator.HomeCreator;
import by.epam.javatraning.aksenov.task1.util.exception.EmptyFileException;
import by.epam.javatraning.aksenov.task1.util.exception.NoValidStringException;
import by.epam.javatraning.aksenov.task1.view.Printable;
import by.epam.javatraning.aksenov.task1.view.PrinterType;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Program implements the hierarchy of electrical equipment in the house.
 * <p>
 * https://github.com/aksenovroma/JavaWebDevelopment_Aksenov_Task1
 *
 * @author aksenov
 * @version 2.0
 */

public class Main {
    private static final Logger log = Logger.getRootLogger();

    private static final String INPUT_FILE = "input/inputTestFile1.txt";
    private static final String OUTPUT_FILE = "output/outputFile.txt";

    public static void main(String[] args) {

        Home homeArray = null;

        try {
            String text = null;

            text = DataReader.readFile(INPUT_FILE);

            List<String> validStringsList = null;

            validStringsList = DataValidator.getValidString(text);

            List<EquipmentBuffer> equipmentTypes = DataParser.parseStrToEquipmentBuffer(validStringsList);
            List<Equipment> equipment = EquipmentCreator.create(equipmentTypes);

            homeArray = new HomeArrayCreator().create();

            homeArray.setEquipment(equipment.toArray(new Equipment[0]));

        } catch (Exception e) {
            log.error(e);
        }

        PrinterType printerType = UserPrinter.select(OUTPUT_FILE);
        Printable printer = PrinterCreator.create(printerType);

        printer.print(homeArray);
        Sorter.bubbleSortByPower(homeArray);
        printer.print(homeArray);

        double count = Calculator.sumPowerOfDevices(homeArray);
        printer.print(count);

        Equipment e = Searcher.findMaxPowerEquipment(homeArray);
        printer.print(e);

    }
}
