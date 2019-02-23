package by.epam.javatraning.aksenov.task1.util;

import java.util.Scanner;

public class UserInput {
    private static Scanner scanner = new Scanner(System.in);

    public static String inputString(){
        if (scanner.hasNextLine()){
            return scanner.nextLine();
        }
        scanner.next();
        return null;
    }
}
