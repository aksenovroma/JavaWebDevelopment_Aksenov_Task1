package by.epam.javatraning.aksenov.task1.view;

public class FilePrint implements Printable{
    @Override
    public void print(Object o) {
        if (o == null){
            return;
        }

        System.out.println("FILE PRINT");
    }
}
