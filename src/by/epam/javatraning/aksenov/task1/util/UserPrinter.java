package by.epam.javatraning.aksenov.task1.util;

import by.epam.javatraning.aksenov.task1.view.PrinterType;

/**
 * @author aksenov
 * @version 1.0
 */
public class UserPrinter {
    private static final String INVITE_FOR_USER = "Select output type of information (Console/File): ";

    /**
     * @return PrinterType class object that user want to use
     */
    public static PrinterType select(String fileName) {
        PrinterType printerType = PrinterType.CONSOLE;

        System.out.println(INVITE_FOR_USER);

        String choice = UserInput.inputString();

        if (choice != null) {
            choice = choice.toUpperCase();

            switch (choice) {
                case "CONSOLE": {
                    printerType = PrinterType.CONSOLE;
                    break;
                }
                case "FILE": {
                    PrinterType.FILE.setFileName(fileName);
                    printerType = PrinterType.FILE;
                    break;
                }
            }
        }

        return printerType;
    }
}
