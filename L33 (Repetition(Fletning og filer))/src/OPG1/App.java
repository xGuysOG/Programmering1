package OPG1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String data = linFileSearchPerson("L33/src/OPG1/personer.txt", "Inge Jensen2");
    }

    public static String linFileSearchPerson(String fileName, String target){
        File file = new File(fileName);
        try (Scanner scanner = new Scanner(file)) {
            System.out.println("Running the data");
            String temp = "";
            while(scanner.hasNextLine()){
                temp = scanner.nextLine().substring(4);
                System.out.println("Substring is " + temp);
                if (temp.equals(target)){
                    return temp;
                }
            }
            return "";
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
