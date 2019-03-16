package by.epam.javatraning.aksenov.task1.util;

import by.epam.javatraning.aksenov.task1.view.ConsolePrint;
import by.epam.javatraning.aksenov.task1.view.FilePrint;
import by.epam.javatraning.aksenov.task1.view.Printable;
import by.epam.javatraning.aksenov.task1.view.PrinterType;

/**
 * @author aksenov
 * @version 1.0
 */
public class PrinterCreator {
    /**
     *
     * @param printerType - type of printer that user want to use
     * @return Printable object
     */
    public static Printable create(PrinterType printerType) {
        Printable printer = null;

        switch (printerType) {
            case CONSOLE: {
                printer = new ConsolePrint();
                break;
            }
            case FILE: {
                printer = new FilePrint(printerType.getFileName());
                break;
            }
        }

        return printer;
    }
}
