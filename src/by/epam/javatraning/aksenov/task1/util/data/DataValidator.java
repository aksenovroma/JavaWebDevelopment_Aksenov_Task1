package by.epam.javatraning.aksenov.task1.util.data;

import java.util.ArrayList;
import java.util.List;

public class DataValidator {
    private static final String DATA_REGEX;

    static {
        DATA_REGEX = "(Microwave|Lamp|Television),\\d+(\\.\\d+)?,\\d+(\\.\\d+)?,(on|off),\\d+(\\.\\d+)?";
    }

    public static List<String> getValidString(List<String> stringList) {
        if (stringList == null) {
            return null;
        }

        List<String> list = new ArrayList<>();

        for (String str : stringList) {
            if (str.matches(DATA_REGEX)) {
                list.add(str);
            }
        }

        return list;
    }
}
