package by.epam.javatraning.aksenov.task1.util.entitycreator;

import by.epam.javatraning.aksenov.task1.model.entity.Equipment;
import by.epam.javatraning.aksenov.task1.util.EquipmentBuffer;

/**
 * @author aksenov
 * @version 1.0
 */
public class EquipmentCreator {
    /**
     *
     * @param equipmentTypes - arrays of objects that must convert to Equipment class objects
     * @return array of Equipment class objects
     */
    public static Equipment[] create(EquipmentBuffer[] equipmentTypes) {
        if (equipmentTypes == null) {
            return null;
        }

        Equipment[] equipment = new Equipment[equipmentTypes.length];

        for (int i = 0; i < equipmentTypes.length; i++) {
            /*
            name of the class whose object we want to create
             */
            String name = equipmentTypes[i].getName();

            Creator creator = chooseCreator(name);

            /*
            initializing variables to create object
             */
            double price = equipmentTypes[i].getPrice();
            double power = equipmentTypes[i].getPower();
            boolean selector = equipmentTypes[i].isSelector();
            String someField = equipmentTypes[i].getSomeField();

            /*
            depending on the type of object the field 'someField' will have different types
             */
            if (creator != null) {
                if (creator instanceof LampCreator) {
                    int lightbulb = Integer.parseInt(someField); //convert someField to int
                    equipment[i] = creator.create(price, power, selector, lightbulb);
                } else if (creator instanceof MicrowaveCreator) {
                    double volume = Double.parseDouble(someField); //convert someField to double
                    equipment[i] = creator.create(price, power, selector, volume);
                } else if (creator instanceof TelevisionCreator) {
                    double diagonal = Double.parseDouble(someField); //convert someField to double
                    equipment[i] = creator.create(price, power, selector, diagonal);
                }
            }
        }
        return equipment;
    }

    /**
     *
     * @param name - name of the class whose object we want to create
     * @return creator object
     */
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
