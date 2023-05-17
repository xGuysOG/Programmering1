package Opgave7;

import javafx.application.Application;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static String toGuess = "i am dead";

    public static void main(String[] args) {
        Application.launch(Gui.class);
        Scanner scanner = new Scanner(System.in);
        ArrayList list = new ArrayList<String>();
        System.out.println("Lets play hangman guess the word * ** ****. Start by guessing a letter");
        String letter = scanner.next();
        if (list.contains(letter)) {
            System.out.println("You have already tried to guess this one");
            Gui.currentStage++;
            Application.launch(Gui.class);
        }
        if (toGuess.contains(letter)) {
            System.out.println("It contains");
            list.add(letter);
            Application.launch(Gui.class);
        } else {
            System.out.println("You sadly lost");
            Gui.currentStage++;
            Application.launch(Gui.class);
        }
    }
}
