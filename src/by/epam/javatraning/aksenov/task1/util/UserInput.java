package by.epam.javatraning.aksenov.task1.util;

import java.util.Scanner;

/**
 * @author aksenov
 * @version 1.0
 *
 * UserInput allows user enter data to console
 */
public class UserInput {
    private static Scanner scanner = new Scanner(System.in);

    /**
     *
     * @return string that user entered in console
     */
    public static String inputString(){
        if (scanner.hasNextLine()){
            return scanner.nextLine();
        }
        scanner.next();
        return null;
    }
}
