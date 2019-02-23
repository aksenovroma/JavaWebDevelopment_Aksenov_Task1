package by.epam.javatraning.aksenov.task1.util.data;

import by.epam.javatraning.aksenov.task1.util.exception.NoValidStringException;

import java.util.ArrayList;
import java.util.List;

public class DataValidator {
    private static final String DATA_REGEX;
    private static final String NO_VALID_STRING_EXCEPTION;

    static {
        DATA_REGEX = "(Microwave|Lamp|Television),\\d+(\\.\\d+)?,\\d+(\\.\\d+)?,(on|off),\\d+(\\.\\d+)?";
        NO_VALID_STRING_EXCEPTION = "file hasn't valid strings";
    }

    public static List<String> getValidString(List<String> stringList) throws NoValidStringException{
        if (stringList == null) {
            return null;
        }

        List<String> list = new ArrayList<>();

        for (String str : stringList) {
            if (str.matches(DATA_REGEX)) {
                list.add(str);
            }
        }

        if (list.size() == 0) {
            throw new NoValidStringException(NO_VALID_STRING_EXCEPTION);
        }

        return list;
    }
}
