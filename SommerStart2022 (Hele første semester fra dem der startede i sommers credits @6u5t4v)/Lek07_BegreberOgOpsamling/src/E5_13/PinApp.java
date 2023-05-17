package E5_13;

import java.util.Scanner;

public class PinApp {
    final static String PIN_CODE = "1234";
    static int maxAttempts = 3;
    static int attempts = 0;


    public static void main(String[] args) {
        System.out.println("Write your PIN CODE to access your bank card!");
        WritePin();
    }

    public static void WritePin() {
        try (Scanner input = new Scanner(System.in)) {
            String attempt = input.nextLine();

            if(attempt.equals(PIN_CODE)){
                System.out.println("Your PIN is correct");
                return;
            }

            if (attempts < maxAttempts) {
                System.out.println("Your PIN is incorrect");
                attempts++;
                WritePin();
            }else if(attempts == maxAttempts){
                System.out.println("Your bank card is blocked");
            }
        } catch (Exception e) {
            System.out.println("ERROR BRUH");
        }
    }
}
