package by.epam.javatraning.aksenov.task1.view;

/**
 * @author aksenov
 * @version 1.0
 *
 * Enum PrinterType used for select the type of information output
 */

public enum PrinterType {
    CONSOLE,
    FILE;

    private String fileName;

    PrinterType() {
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}


