package application.model.P1_2;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {
    public MainMenu() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setBackground(Color.gray);
        setTitle("Car's Work Commute");
        setPreferredSize(new Dimension(300, 300));

        JTextField distToWorkInput = new JTextField("50");
        JTextField startOdometerInput = new JTextField("450");
        JTextField endOdometerInput = new JTextField("930");
        JTextField numberOfWeekDaysInput = new JTextField("3");

        Object[] message = {
                "Hvor langt har du til arbejde", distToWorkInput,
                "Hvor var din odometer da du startede", startOdometerInput,
                "Hvor langt har du til arbejde", endOdometerInput,
                "Hvor mange dage om ugen arbejder du", numberOfWeekDaysInput
        };

        add(distToWorkInput);

        setVisible(true);
    }
}
