package by.epam.javatraning.aksenov.task1.view;

/**
 * @author aksenov
 * @version 1.0
 *
 * ConsolePrint used for print information to console
 */
public class ConsolePrint implements Printable {
    @Override
    public void print(Object o) {
        if (o != null) {
            System.out.println(o);
        }
    }
}
