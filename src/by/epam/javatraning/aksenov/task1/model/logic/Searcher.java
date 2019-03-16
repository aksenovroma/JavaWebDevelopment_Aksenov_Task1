package by.epam.javatraning.aksenov.task1.model.logic;

import by.epam.javatraning.aksenov.task1.model.entity.Equipment;
import by.epam.javatraning.aksenov.task1.model.entity.container.Home;
import org.apache.log4j.Logger;

/**
 * @author aksenov
 * @version 1.0
 *
 * Action-class works with information from class Home
 * Searcher seeks information according to different characteristics
 */

public class Searcher {
    private static final Logger log = Logger.getRootLogger();

    private static final String INDEX_OF_EQUIPMENT_BY_POWER = "method findIndexOfEquipmentByPower returned = ";
    private static final String INDEX_OF_EQUIPMENT_BY_PRICE = "method findIndexOfEquipmentByPrice returned = ";
    private static final String MAX_PRICE_EQUIPMENT = "method findMaxPriceEquipment returned = ";
    private static final String MIN_PRICE_EQUIPMENT = "method findMinPriceEquipment returned = ";
    private static final String MAX_POWER_EQUIPMENT = "method findMaxPowerEquipment returned = ";
    private static final String MIN_POWER_EQUIPMENT = "method findMinPowerEquipment returned = ";

    /**
     *
     * @param home - Home class object
     * @param power - the value we want to find equipment
     * @return index of equipment with power == key
     */
    public static int findIndexOfEquipmentByPower(Home home, double power) {
        if (home != null && !(home.isEmpty())) {
            for (int i = 0; i < home.size(); i++) {
                if (home.get(i).getPower() == power) {
                    log.info(INDEX_OF_EQUIPMENT_BY_POWER + i);
                    return i;
                }
            }
        }
        log.info(INDEX_OF_EQUIPMENT_BY_POWER + -1);

        return -1;
    }

    /**
     *
     * @param home - Home class object
     * @param price - the value we want to find equipment
     * @return index of equipment with price == key
     */
    public static int findIndexOfEquipmentByPrice(Home home, double price) {
        if (home != null && !(home.isEmpty())) {
            for (int i = 0; i < home.size(); i++) {
                if (home.get(i).getPrice() == price) {
                    log.info(INDEX_OF_EQUIPMENT_BY_PRICE + i);
                    return i;
                }
            }
        }
        log.info(INDEX_OF_EQUIPMENT_BY_PRICE + -1);

        return -1;
    }

    /**
     *
     * @param home - Home class object
     * @return equipment with max price
     */
    public static Equipment findMaxPriceEquipment(Home home) {
        Equipment maxPriceEquipment = null;

        if (home != null && !(home.isEmpty())) {
            maxPriceEquipment = home.get(0);

            for (int i = 0; i < home.size(); i++) {
                Equipment tempEquipment = home.get(i);

                if (maxPriceEquipment.getPrice() < tempEquipment.getPrice()) {
                    maxPriceEquipment = tempEquipment;
                }
            }
        }
        log.info(MAX_PRICE_EQUIPMENT + maxPriceEquipment);

        return maxPriceEquipment;
    }

    /**
     *
     * @param home - Home class object
     * @return equipment with min price
     */
    public static Equipment findMinPriceEquipment(Home home) {
        Equipment minPriceEquipment = null;

        if (home != null && !(home.isEmpty())) {
            minPriceEquipment = home.get(0);

            for (int i = 0; i < home.size(); i++) {
                Equipment tempEquipment = home.get(i);

                if (minPriceEquipment.getPrice() > tempEquipment.getPrice()) {
                    minPriceEquipment = tempEquipment;
                }
            }
        }
        log.info(MIN_PRICE_EQUIPMENT + minPriceEquipment);

        return minPriceEquipment;
    }

    /**
     *
     * @param home - Home class object
     * @return equipment with max power
     */
    public static Equipment findMaxPowerEquipment(Home home) {
        Equipment maxPowerEquipment = null;

        if (home != null && !(home.isEmpty())) {
            maxPowerEquipment = home.get(0);

            for (int i = 0; i < home.size(); i++) {
                Equipment tempEquipment = home.get(i);

                if (maxPowerEquipment.getPower() < tempEquipment.getPower()) {
                    maxPowerEquipment = tempEquipment;
                }
            }
        }
        log.info(MAX_POWER_EQUIPMENT + maxPowerEquipment);

        return maxPowerEquipment;
    }

    /**
     *
     * @param home - Home class object
     * @return equipment with min power
     */
    public static Equipment findMinPowerEquipment(Home home) {
        Equipment minPowerEquipment = null;

        if (home != null && !(home.isEmpty())) {
            minPowerEquipment = home.get(0);

            for (int i = 0; i < home.size(); i++) {
                Equipment tempEquipment = home.get(i);

                if (minPowerEquipment.getPower() > tempEquipment.getPower()) {
                    minPowerEquipment = tempEquipment;
                }
            }
        }
        log.info(MIN_POWER_EQUIPMENT + minPowerEquipment);

        return minPowerEquipment;
    }
}