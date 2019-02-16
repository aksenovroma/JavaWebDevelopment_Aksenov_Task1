package by.epam.javatraning.aksenov.task1.util;

import java.io.*;
import java.util.ArrayList;

public class DataReader{
    public static ArrayList<String> readStringsFromFile(String filename){
        if (filename == null){
            return null;
        }

        ArrayList<String> arrayList = new ArrayList<>(0);
        FileInputStream fstream = null;

        try{
            fstream = new FileInputStream(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;

            while ((strLine = br.readLine()) != null){
                arrayList.add(strLine);
            }
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }finally{
            try{
                if (fstream != null)
                    fstream.close();
            }
            catch(IOException e){
                System.out.println(e.getMessage());
            }
        }

        return arrayList;
    }
}