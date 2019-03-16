package by.epam.javatraning.aksenov.task1.model.logic;

import by.epam.javatraning.aksenov.task1.model.entity.Equipment;
import by.epam.javatraning.aksenov.task1.model.entity.container.Home;
import org.apache.log4j.Logger;

/**
 * @author aksenov
 * @version 1.0
 * <p>
 * Action-class works with information from class Home
 * Sorter sorts information according to different characteristics
 */

public class Sorter {
    private static final Logger log = Logger.getRootLogger();

    private static final String SUCCESSFUL_SORT_BY_POWER = "sort was finished";
    /**
     * Method sorts information by power
     *
     * @param home - Home class object
     */
    public static void bubbleSortByPower(Home home) {
        if (home != null && !(home.isEmpty())) {
            for (int i = 0; i < home.size() - 1; i++) {
                for (int j = 0; j < home.size() - i - 1; j++) {
                    Equipment e1 = home.get(j);
                    Equipment e2 = home.get(j + 1);

                    if (e1.getPower() < e2.getPower()) {
                        home.set(e2, j);
                        home.set(e1, j + 1);
                    }
                }
            }
            log.trace(SUCCESSFUL_SORT_BY_POWER);
        }
    }
}
