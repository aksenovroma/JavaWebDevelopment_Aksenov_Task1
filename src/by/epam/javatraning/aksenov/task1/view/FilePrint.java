package by.epam.javatraning.aksenov.task1.view;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author aksenov
 * @version 1.0
 *
 * FilePrint used for print information to file
 */
public class FilePrint implements Printable {
    @Override
    public void print(Object o) {
        if (o == null) {
            return;
        }

        try (FileWriter fileWriter = new FileWriter("output/outputFile.txt", true)) {
            fileWriter.write(o.toString() + '\n');
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
