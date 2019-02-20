package by.epam.javatraning.aksenov.task1.util.data;

import by.epam.javatraning.aksenov.task1.util.EquipmentType;

import java.util.List;

public class DataConverter {
    public static EquipmentType[] convertStrToEquipmentType(List<String> list) {
        if (list == null) {
            return null;
        }

        EquipmentType[] equipmentTypes = new EquipmentType[list.size()];
        int index = 0;

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

            equipmentTypes[index] = new EquipmentType(name, price, power, selector, someField);
            index++;
        }

        return equipmentTypes;
    }
}
