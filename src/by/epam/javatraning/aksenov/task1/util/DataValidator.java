package by.epam.javatraning.aksenov.task1.util;

import java.util.ArrayList;

public class DataValidator {
    private static final String DATA_REGEX = "(Microwave|Lamp|Toaster),\\d+(\\.\\d+)?,(on|off)";

    public static ArrayList<String> getValidString(ArrayList<String> arrayOfString){
        if (arrayOfString == null){
            return null;
        }

        ArrayList<String> arrayList = new ArrayList<>();

        for (String str : arrayOfString){
            if (str.matches(DATA_REGEX)) {
                arrayList.add(str);
            }
        }

        return arrayList;
    }
}
