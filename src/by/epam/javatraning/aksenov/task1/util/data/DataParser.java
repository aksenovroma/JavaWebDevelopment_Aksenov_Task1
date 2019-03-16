package by.epam.javatraning.aksenov.task1.util.data;

import by.epam.javatraning.aksenov.task1.util.EquipmentBuffer;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aksenov
 * @version 1.0
 *
 * Class DataConvert converts valid string to EquipmentType -
 * (special entity-class that storing information about equipments)
 */
public class DataParser {
    private static final Logger log = Logger.getRootLogger();

    private static final String SUCCESSFUL_PARSING = "data was parse";
    /**
     *
     * @param list - list of valid strings with information about equipments
     * @return array of EquipmentType class objects
     */
    public static List<EquipmentBuffer> parseStrToEquipmentBuffer(List<String> list) {
        if (list != null) {
            List<EquipmentBuffer> equipmentBuffers = new ArrayList<>(list.size());

            for (String string : list) {
                String[] strArr = string.split(",");

                String name = strArr[0];
                double price = Double.parseDouble(strArr[1]);
                double power = Double.parseDouble(strArr[2]);
                boolean selector = false;
                {
                    if (strArr[3].equals("on")) {
                        selector = true;
                    }
                }
                String someField = strArr[4];

                equipmentBuffers.add(new EquipmentBuffer(name, price, power, selector, someField));
            }
            log.trace(SUCCESSFUL_PARSING);

            return equipmentBuffers;
        }

        return null;
    }
}
