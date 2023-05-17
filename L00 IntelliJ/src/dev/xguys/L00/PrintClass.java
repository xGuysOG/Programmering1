package dev.xguys.L00;

public class PrintClass {
    public static void main(String[] args) {
        HelloWorld();
        WelcomeToJava();
        ILoveJava();
        DisplayPattern();
        DisplayTable();
        DisplayMath();
        DisplayResultSet();
        DisplayPimath();
        DisplayAreaAndPerimeterCircle();
        DisplayAreaAndPerimeterRectangle();
        DisplayRunnerMath();
    }

    public static void HelloWorld() {
        System.out.println("Hello World");
    }

    public static void WelcomeToJava() {
        System.out.println("Welcome to Java");
        System.out.println("Learning Java Now");
        System.out.println("Programming is fun");
    }

    public static void ILoveJava() {
        for (int i = 0; i < 5; ++i) {
            System.out.println("I love Java");
        }
    }

    public static void DisplayPattern() {
        System.out.println("   J    a   v     v  a ");
        System.out.println("   J   a a   v   v  a a");
        System.out.println("J  J  aaaaa   V V  aaaaa");
        System.out.println(" JJ  a     a   V  a     a");
    }

    public static void DisplayTable() {
        System.out.println("a	a^2	 a^3");
        System.out.println("1	1  	 1");
        System.out.println("2	4  	 8");
        System.out.println("3	9  	 27");
        System.out.println("4	10 	 64");
    }

    public static void DisplayMath() {
        double topEquation = 7.5 * 6.5 - 4.5 * 3;
        double bottomEqation = 47.5 - 5.5;
        double Result = topEquation / bottomEqation;
        System.out.println("Result of 7.5 * 6.5 - 4.5 * 3 47.5 - 5.5 is = " + Result);
    }

    public static void DisplayResultSet() {
        double Result = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10;
        System.out.println("Result of 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 is: " + Result);
    }

    public static void DisplayPimath() {
        System.out.println("Result of PI math 1 " + 4 * (1.0 - (1 / 3) + (1 / 5) -
                (1 / 7) + (1 / 9) - (1 / 11)));
        System.out.println("Result of PI math 2 " + 4 * (1.0 - (1 / 3) + (1 / 5) - (1 / 7)
                + (1 / 9) - (1 / 11) + (1 / 13)));
    }

    public static void DisplayAreaAndPerimeterCircle() {
        double radius = 6.5;
        double pi = 3.14159;
        System.out.println("Displaying Area and Perimeter for Circle");
        System.out.println("Perimeter = " + 2 * radius * pi);
        System.out.println("Area = " + radius * radius * pi);
    }

    public static void DisplayAreaAndPerimeterRectangle() {
        double width = 5.3;
        double height = 8.6;
        System.out.println("Displaying Area and Perimeter for Rectangle");
        System.out.println("Area = " + width * height);
        System.out.println("Perimeter = " + 2 * (width + height));
    }

    public static void DisplayRunnerMath() {
        double miles = 15.0 / 1.6;

        double rate = (50.5 * 60.0 +30) / 3600.0;
        double mpH = miles / rate;

        System.out.println("Displaying Miles Pr Hour Math 1.10");
        System.out.println("He runs " + mpH);
    }

    public static void PopulationStuff() {
        int currentPopulation = 312032486;
        int days = 365;
        int secondsPrYear = 31536000;
        double birth = 31536000 / 7;
        double death = 31536000 / 13;
        double Immigrant = 31536000 / 45;
        int newPopulation = (int) (birth - death + Immigrant);
        int year1 = currentPopulation + newPopulation;
        int year2 = year1 + newPopulation;
        int year3 = year2 + newPopulation;
        int year4 = year3 + newPopulation;
        int year5 = year4 + newPopulation;
        System.out.println("Displaying Population math 1.11");
        System.out.println("Year 1 = " + year1);
        System.out.println("Year 2 = " + year2);
        System.out.println("Year 3 = " + year3);
        System.out.println("Year 4 = " + year4);
        System.out.println("Year 5 = " + year5);
        //Birth = 7 seconds
        //Death = 14 seconds
        //Immigrant = 45 seconds
    }



}
