package by.epam.javatraning.aksenov.task1.util.entitycreator;

import by.epam.javatraning.aksenov.task1.model.entity.Equipment;
import by.epam.javatraning.aksenov.task1.util.EquipmentType;
import by.epam.javatraning.aksenov.task1.util.entitycreator.Creator;
import by.epam.javatraning.aksenov.task1.util.entitycreator.LampCreator;
import by.epam.javatraning.aksenov.task1.util.entitycreator.MicrowaveCreator;
import by.epam.javatraning.aksenov.task1.util.entitycreator.TelevisionCreator;

public class EquipmentCreator {
    public static Equipment[] create(EquipmentType[] equipmentTypes) {
        if (equipmentTypes == null) {
            return null;
        }

        Equipment[] equipment = new Equipment[equipmentTypes.length];

        for (int i = 0; i < equipmentTypes.length; i++) {
            String name = equipmentTypes[i].getName();

            Creator creator = chooseCreator(name);

            double price = equipmentTypes[i].getPrice();
            double power = equipmentTypes[i].getPower();
            boolean selector = equipmentTypes[i].isSelector();
            String someField = equipmentTypes[i].getSomeField();

            if (creator != null) {
                if (creator instanceof LampCreator) {
                    int lightbulb = Integer.parseInt(someField);
                    equipment[i] = creator.create(price, power, selector, lightbulb);
                } else if (creator instanceof MicrowaveCreator) {
                    double volume = Double.parseDouble(someField);
                    equipment[i] = creator.create(price, power, selector, volume);
                } else if (creator instanceof TelevisionCreator) {
                    double diagonal = Double.parseDouble(someField);
                    equipment[i] = creator.create(price, power, selector, diagonal);
                }
            }
        }
        return equipment;
    }

    private static Creator chooseCreator(String name) {
        if (name == null) {
            return null;
        }

        Creator creator = null;

        switch (name) {
            case "Microwave": {
                creator = new MicrowaveCreator();
                break;
            }
            case "Lamp": {
                creator = new LampCreator();
                break;
            }
            case "Television": {
                creator = new TelevisionCreator();
                break;
            }
        }

        return creator;
    }
}
