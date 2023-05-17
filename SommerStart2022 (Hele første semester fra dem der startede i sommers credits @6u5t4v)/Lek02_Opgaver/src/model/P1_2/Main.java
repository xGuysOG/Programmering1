package application.model.P1_2;

import javax.swing.*;

public class Main {
    static double distToWork = 150.0d;
    static double startOdometer = 240.0d;
    static double endOdometer = 940.0d;
    static int numberOfWorkDays = 3;

    public static void main(String[] args) {
        startProgram();
    }

    private static void startProgram() {
        JTextField distToWorkInput = new JTextField(String.valueOf(distToWork));
        JTextField startOdometerInput = new JTextField(String.valueOf(startOdometer));
        JTextField endOdometerInput = new JTextField(String.valueOf(endOdometer));
        JTextField numberOfWorkDaysInput = new JTextField(String.valueOf(numberOfWorkDays));

        Object[] message = {
                "Hvor langt har du til arbejde", distToWorkInput,
                "Hvor var din odometer da du startede", startOdometerInput,
                "Hvor langt har du til arbejde", endOdometerInput,
                "Hvor mange dage om ugen arbejder du", numberOfWorkDaysInput
        };

        int option = JOptionPane.showConfirmDialog(null,
                message,
                "Car's Work Commute",
                JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            try {
                distToWork = Double.parseDouble(distToWorkInput.getText());
                numberOfWorkDays = Integer.parseInt(numberOfWorkDaysInput.getText());
                startOdometer = Double.parseDouble(startOdometerInput.getText());
                endOdometer = Double.parseDouble(endOdometerInput.getText()) + ((distToWork * 2) * numberOfWorkDays);

                if (startOdometer > endOdometer) {
                    JOptionPane.showInternalMessageDialog(distToWorkInput, "Start målingen kan ikke være størrer end slut mållingen");
                    startProgram();
                    return;
                }

                // Den totale mileage kørt
                double totalCommute = endOdometer - startOdometer;
                // Den totale mileage det tager at pendle til og fra arbejde
                double toWorkTotalCommuteMileage = (distToWork * 2) * numberOfWorkDays;

                double personalCommute = totalCommute - toWorkTotalCommuteMileage;
                System.out.println(totalCommute + " " + toWorkTotalCommuteMileage + " " + personalCommute);


            } catch (NullPointerException e) {
                JOptionPane.showInternalMessageDialog(distToWorkInput, "Alle inputs skal være angivet");
                startProgram();
            }

        } else {
            System.out.println("Rejected");
        }
    }
}
