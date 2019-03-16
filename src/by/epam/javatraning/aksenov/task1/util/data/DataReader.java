package by.epam.javatraning.aksenov.task1.util.data;

import by.epam.javatraning.aksenov.task1.util.exception.EmptyFileException;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author aksenov
 * @version 1.0
 *
 * DataReader reads information from different sources
 */

public class DataReader {
    private static final Logger log = Logger.getRootLogger();

    private static final String EMPTY_FILE_EXCEPTION = "file is empty";
    private static final String SUCCESSFUL_READING = "data was read";

    /**
     *
     * @param filename - the name of the file from which we want to read the information
     * @return - list of strings from file
     * @throws EmptyFileException - exception is thrown if the file is empty
     */
    public static String readFile(String filename) throws EmptyFileException{
        if (filename != null) {
            StringBuilder builder = new StringBuilder();

            try (FileInputStream fstream = new FileInputStream(filename);
                 BufferedReader br = new BufferedReader(new InputStreamReader(fstream))){

                String strLine;

                while ((strLine = br.readLine()) != null) {
                    builder.append(strLine).append("\n");
                }

                if (builder.length() == 0){
                    throw new EmptyFileException(EMPTY_FILE_EXCEPTION);
                }

            } catch (IOException e) {
                log.error(e);
            }
            log.trace(SUCCESSFUL_READING);

            return builder.toString();
        }

        return null;
    }
}