package test;

import model.Student;
import model.Team;

import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.Scanner;

public class MenuApp {
    public static Team[] teams = new Team[10];
    public static int amountOfTeams = 0;
    public static void main(String[] args) {
        int choice;
        do {
            // Get user choice
            choice = printMenu();
            if (isValid(choice)) {
                menuChoices(choice);
            } else {
                System.out.println("Wrong input please input a number between 1 and 6");
            }
        } while (choice != 6); // If 6 exit main menu
        System.out.println("--> Program finished");
        // Once you exit, the system will prompt for an id again
    }

    public static void menuChoices(int choice) {
        Scanner scanner = new Scanner(System.in);
        switch (choice) {
            case 1 -> {
                option1(scanner);
            }
            case 2 -> {
                option2(scanner);
            }
            case 3 -> {
                option3(scanner);
            }
            case 4 -> {
                option4(scanner);
            }
            case 5 -> {
                option5(scanner);
            }
            default -> {
                System.out.println("--> FEJL! Ukendt valg");
            }
        }
        System.out.println();
    }
    public static void option1(Scanner scanner) {
        System.out.print("Team name and room");
        String teamName = scanner.next();
        String roomName = scanner.next();
        Team team = new Team(teamName, roomName);
        teams[amountOfTeams] = team;
        amountOfTeams++;

        System.out.println("--> Team created with name and room set to " + teamName + " and " + roomName);
    }

    public static void option2(Scanner scanner)  {
        System.out.print("Name of student's team");
        String teamName = scanner.next();
        Team team = getTeam(teamName);
        if (team != null) {
            System.out.print("Student's name and activity status (true/false):");
            String studentName = scanner.next();
            boolean studentStatus = scanner.nextBoolean();
            System.out.print("Student's number of grades:");
            int numberOfGrades = scanner.nextInt();
            int[] studentsGrades = new int[numberOfGrades];
            System.out.print("Student's " + numberOfGrades + " grades:");
            for(int i = 0; i < numberOfGrades; i++) {
                studentsGrades[i] = scanner.nextInt();
            }
            Student student = new Student(studentName, studentStatus, studentsGrades);
            team.addStudent(student);
            System.out.println("--> Student " + studentName + " isActive " + studentStatus + " with grades " + Arrays.toString(studentsGrades) + "created in team " + teamName);
        } else {
            System.out.println("Team dosnt exist please try again");
        }
    }

    public static void option3(Scanner scanner){
        System.out.print("Student name and team: ");
        String name = scanner.next();
        String teamName = scanner.next();
        Team team = getTeam(teamName);
        Student student = getStudent(name, teamName);
        System.out.println(team.getStudentInfo(student));

    }

    public static void option4(Scanner scanner) {
        System.out.print("Team's name:");
        Team team = getTeam(scanner.next());
        if (team != null) {
            System.out.println("--> Team info for team with name " + team.getName());
            System.out.println("Statistics for team: " + team.getName());
            for (String string : team.studentInfo()) {
                System.out.println(string);
            }
        } else {
            System.out.println("Team dosnt exist please try again");
        }
    }

    public static void option5(Scanner scanner) {
        System.out.println("Statitics of the teams ");
        for (Team team : teams) {
            if (team != null) {
                System.out.println("Team info " + team.getName());
                System.out.println("Average " + team.teamAverageGrades());
                System.out.println("The room name is: " + team.getRoom());
                int[] amount = team.getAmountCorrectAnswers();
                for (int i = 0; i < amount.length; i++) {
                    System.out.println(amount[i] + " Answered correct in question: " + (i + 1));

                }
                System.out.println("--------------------------------");
            }
        }
    }

    public static Student getStudent(String name, String teamName){
        Team team = getTeam(teamName);
        for (Student student : team.getStudents()){
            if (student.getName().equals(name)){
                return student;
            }
        }
        return null;
    }
    public static Team getTeam(String teamName) {
        for(Team team : teams) {
            if (team != null && team.getName().equals(teamName)) {
                return team;
            }
        }
        return null;
    }

    public static boolean isValid(int choice) {
        return choice < 7 && choice > 0;
    }

    public static int printMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("MENU");
        System.out.println("1: Create a team");
        System.out.println("2: Create a student");
        System.out.println("3: Show one students info and results");
        System.out.println("4: Show one team's info and results ");
        System.out.println("5: Show info and results for all teams ");
        System.out.println("6: Exit program ");
        return scanner.nextInt();
    }
}
