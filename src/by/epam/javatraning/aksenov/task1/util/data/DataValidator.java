package by.epam.javatraning.aksenov.task1.util.data;

import by.epam.javatraning.aksenov.task1.util.exception.NoValidStringException;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aksenov
 * @version 2.0
 *
 * DataValidator checks if the data is appropriate
 */

public class DataValidator {
    private static final Logger log = Logger.getRootLogger();

    private static final String SUCCESSFUL_VALIDATION = "data was validate";

    private static final String DATA_REGEX;
    private static final String NO_VALID_STRING_EXCEPTION;

    static {
        DATA_REGEX = "(Microwave|Lamp|Television),\\d+(\\.\\d+)?,\\d+(\\.\\d+)?,(on|off),\\d+(\\.\\d+)?";
        NO_VALID_STRING_EXCEPTION = "file hasn't valid strings";
    }

    /**
     *
     * @param text - list of strings that we want to check
     * @return - list of strings that are fit the pattern DATA_REGEX
     * @throws NoValidStringException - exception is thrown if the list hasn't valid strings
     */
    public static List<String> getValidString(String text) throws NoValidStringException {
        if (text != null) {
            String[] strings = text.split("\\n");

            List<String> list = new ArrayList<>();

            for (String str : strings) {
                if (str.matches(DATA_REGEX)) {
                    list.add(str);
                }
            }

            if (list.size() == 0) {
                throw new NoValidStringException(NO_VALID_STRING_EXCEPTION);
            }
            log.trace(SUCCESSFUL_VALIDATION);

            return list;
        }

        return null;
    }
}
