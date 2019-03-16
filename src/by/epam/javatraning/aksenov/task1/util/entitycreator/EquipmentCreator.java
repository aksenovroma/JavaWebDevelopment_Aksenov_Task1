package by.epam.javatraning.aksenov.task1.util.entitycreator;

import by.epam.javatraning.aksenov.task1.model.entity.Equipment;
import by.epam.javatraning.aksenov.task1.model.entity.Lamp;
import by.epam.javatraning.aksenov.task1.model.entity.Microwave;
import by.epam.javatraning.aksenov.task1.model.entity.Television;
import by.epam.javatraning.aksenov.task1.model.exception.logic.WrongArgumentException;
import by.epam.javatraning.aksenov.task1.util.EquipmentBuffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aksenov
 * @version 1.0
 */
public class EquipmentCreator {
    /**
     *
     * @param equipmentBuffers - arrays of objects that must convert to Equipment class objects
     * @return array of Equipment class objects
     */
    public static List<Equipment> create(List<EquipmentBuffer> equipmentBuffers) {
        List<Equipment> equipment = null;

        if (equipmentBuffers != null) {
            equipment = new ArrayList<>();

            for (EquipmentBuffer eBuffer : equipmentBuffers) {
                int index = equipmentBuffers.indexOf(eBuffer);
                /*
                name of the class whose object we want to create
                 */
                String name = eBuffer.getName();

                Creator creator = chooseCreator(name);

                if (creator != null) {
                    equipment.add(creator.create());

                    String someField = eBuffer.getSomeField();
                    Equipment tempEquipment = equipment.get(index);

                    try {
                        tempEquipment.setPrice(eBuffer.getPrice());
                        tempEquipment.setPower(eBuffer.getPower());
                        tempEquipment.setSelector(eBuffer.isSelector());

                        if (creator instanceof LampCreator) {
                            int lightbulb = Integer.parseInt(someField);
                            ((Lamp) tempEquipment).setLightbulb(lightbulb);
                        } else if (creator instanceof MicrowaveCreator) {
                            double volume = Double.parseDouble(someField);
                            ((Microwave) tempEquipment).setVolume(volume);
                        } else {
                            double diagonal = Double.parseDouble(someField);
                            ((Television) tempEquipment).setDiagonal(diagonal);
                        }
                    } catch (WrongArgumentException e) {
                        e.printStackTrace();
                    }
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
        Creator creator = null;

        if (name != null) {
            switch (name.toUpperCase()) {
                case "MICROWAVE": {
                    creator = new MicrowaveCreator();
                    break;
                }
                case "LAMP": {
                    creator = new LampCreator();
                    break;
                }
                case "TELEVISION": {
                    creator = new TelevisionCreator();
                    break;
                }
            }
        }

        return creator;
    }
}
