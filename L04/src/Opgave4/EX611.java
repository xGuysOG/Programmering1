package Opgave4;

public class EX611 {
    public static void main(String[] args) {
        int min = 1000;
        while (min <= 20000){
            System.out.println("Input is " + min + " compute is "+ computeCommission(min));
            min += 1000;
        }
    }

    public static double computeCommission(double salesAmount) {
        double balance;
        double comm;
        balance = comm = 0.0;

        if (salesAmount > 10000) {
            double math = (balance = salesAmount - 10000) * 0.10;
            comm += math;
            salesAmount -= balance;
        }
        if (salesAmount > 5000 && salesAmount <= 10000) {
            double math = (balance = salesAmount - 5000) * 0.08;
            comm += math;
            salesAmount -= balance;

        }
        if (salesAmount <= 5000) {
            comm += salesAmount * 0.06;
        }
//        def getSales(money):
//        if (money <= 5000):
//        return money * 0.08
//        elif (money <= 10000):
//        return 5000 * 0.08 + (money-5000) * 0.1
//        elif (money > 10000):
//        return 5000 * 0.08 + 5000 * 0.1 + (money - 10000) * 0.12

        return comm;
    }
}
