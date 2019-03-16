package by.epam.javatraning.aksenov.task1.view;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author aksenov
 * @version 2.0
 *
 * FilePrint used for print information to file
 */
public class FilePrint implements Printable {
    private String fileName;

    public FilePrint(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void print(Object o) {
        if (o != null) {
            try (FileWriter fileWriter = new FileWriter(fileName, true)) {
                fileWriter.write(o.toString() + '\n');
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
