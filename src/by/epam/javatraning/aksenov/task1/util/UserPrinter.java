package by.epam.javatraning.aksenov.task1.util;

import by.epam.javatraning.aksenov.task1.view.PrinterType;

import java.util.Scanner;

public class UserPrinter {
    private static final String INVITE_FOR_USER = "Select output type of information (Console/File): ";

    public static PrinterType select() {
        PrinterType printerType = PrinterType.CONSOLE;

        System.out.println(INVITE_FOR_USER);

        String choice = UserInput.inputString();

        if (choice == null){
            return printerType;
        }

        choice = choice.toUpperCase();

        switch (choice) {
            case "CONSOLE": {
                printerType = PrinterType.CONSOLE;
                break;
            }
            case "FILE": {
                printerType = PrinterType.FILE;
                break;
            }
        }

        return printerType;
    }
}
