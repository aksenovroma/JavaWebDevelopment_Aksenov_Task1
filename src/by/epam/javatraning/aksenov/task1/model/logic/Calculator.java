package by.epam.javatraning.aksenov.task1.model.logic;

import by.epam.javatraning.aksenov.task1.model.entity.Equipment;
import by.epam.javatraning.aksenov.task1.model.entity.container.Home;
import by.epam.javatraning.aksenov.task1.model.entity.container.HomeArray;
import org.apache.log4j.Logger;

/**
 * @author aksenov
 * @version 1.0
 *
 * Action-class works with information from class Home
 * Сalculator makes calculations according to different characteristics
 */

public class Calculator {
    private static final Logger log = Logger.getRootLogger();

    private static final String SUM_POWER_OF_DEVICE = "method sumPowerOfDevices returned = ";
    private static final String SUM_POWER_OF_ON_DEVICE = "method sumPowerOfOnDevices returned = ";
    /**
     *
     * @param home - Home class object
     * @return sum of the powers of the devices in the house
     */
    public static double sumPowerOfDevices(Home home) {
        double sumPower = 0;

        if ((home != null) && !(home.isEmpty())) {
            for (int i = 0; i < home.size(); i++) {
                sumPower += home.get(i).getPower();
            }
        }
        log.info(SUM_POWER_OF_DEVICE + sumPower);

        return sumPower;
    }

    /**
     *
     * @param home - Home class object
     * @return sum of the powers of the devices (that is ON) in the house
     */
    public static double sumPowerOfOnDevices(HomeArray home) {
        double sumPower = 0;

        if ((home != null) && !(home.isEmpty())) {
            for (int i = 0; i < home.size(); i++) {
                Equipment equipment = home.get(i);

                if (equipment.isSelector()) {
                    sumPower += home.get(i).getPower();
                }
            }
        }
        log.info(SUM_POWER_OF_ON_DEVICE + sumPower);

        return sumPower;
    }
}
