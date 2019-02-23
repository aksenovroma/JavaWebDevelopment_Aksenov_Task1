package by.epam.javatraning.aksenov.task1.util.data;

import by.epam.javatraning.aksenov.task1.util.exception.EmptyFileException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    private static final String EMPTY_FILE_EXCEPTION = "file is empty";

    public static List<String> readFile(String filename) throws EmptyFileException{
        if (filename == null) {
            return null;
        }

        List<String> stringList = new ArrayList<>(0);
        FileInputStream fstream = null;

        try {
            fstream = new FileInputStream(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;

            while ((strLine = br.readLine()) != null) {
                stringList.add(strLine);
            }

            if (stringList.size() == 0){
                throw new EmptyFileException(EMPTY_FILE_EXCEPTION);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fstream != null)
                    fstream.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        return stringList;
    }
}