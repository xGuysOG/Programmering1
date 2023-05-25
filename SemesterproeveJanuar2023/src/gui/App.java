package gui;

import controller.Controller;

public class App {
    public static void main(String[] args) {
        System.out.println("Error test");
        Controller.initStorage();
        Gui.launch(Gui.class);
    }
}
