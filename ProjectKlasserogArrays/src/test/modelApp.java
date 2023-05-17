package test;

import model.Student;
import model.Team;
import java.util.Arrays;

public class modelApp {
    public static void main(String[] args) {
        Team team1 = new Team("Team1", "1.22B");
        Team team2 = new Team("Team2", "2.22A");

        Student student1 = new Student("Lars", true, new int[]{7, 10, 7, 4});
        Student student2 = new Student("Jens", false, new int[]{2, 2, 2, 4});
        Student student3 = new Student("Ole", true, new int[]{12, 12, 2, 4});
        team1.addStudent(student1);
        team1.addStudent(student2);
        team1.addStudent(student3);
        Student student4 = new Student("Malte", true, new int[]{7, 10, 7, 4});
        Student student5 = new Student("Jonas", false, new int[]{10, 10, 10, 4});
        Student student6 = new Student("Lasse", true, new int[]{12, 10, 12, 4});
        team2.addStudent(student4);
        team2.addStudent(student5);
        team2.addStudent(student6);
        System.out.println("Team1 " + team1.toString());
        System.out.println("Team2 " + team2.toString());


        System.out.println("Testing getStudents team1" + Arrays.toString(team1.getStudents()));

        System.out.println("Testing getStudents team2" + Arrays.toString(team2.getStudents()));

        team1.removeStudent2("Jens");
        System.out.println("Removed middel student of team1");

        team2.removeStudent2("Malte");
        System.out.println("Removed first student of team2");

        System.out.println("Testing getStudents team1" + Arrays.toString(team1.getStudents()));

        System.out.println("Testing getStudents team2" + Arrays.toString(team2.getStudents()));

        team1.addStudent(student4);
        System.out.println("Adding the removed student from team2 to team1");

        team2.addStudent(student2);
        System.out.println("Adding the removed student from team2 to team1");

        System.out.println("Testing getStudents team1" + Arrays.toString(team1.getStudents()));

        System.out.println("Testing getStudents team2" + Arrays.toString(team2.getStudents()));
        for (Student student : team1.getStudents()) {
            student.generateMultipleChoiceAnswers();
        }
        for (Student student : team2.getStudents()) {
            student.generateMultipleChoiceAnswers();
        }

        System.out.println("Team1 " + team1.toString());
        System.out.println("Team2 " + team2.toString());

        System.out.println("Highest grade " + student6.getHighestGrade());
        System.out.println("Average grade " + student6.getAverageGrade());
        System.out.println("Team averge grade " + team1.teamAverageGrades());
        System.out.println("Students that have above 7 in grade " + Arrays.toString(team1.highScoreStudents(7)));

        System.out.println("Data from team 1 " + Arrays.toString(team1.correctAnswerCount()));
        System.out.println("Data from team 2 " + Arrays.toString(team2.correctAnswerCount()));

       // System.out.println("Team1 student info " + Arrays.toString(team1.studentInfo()));
        System.out.println("Team 1 studentinfo");
        for (String string : team1.studentInfo()) {
            System.out.println(string);
        }
        System.out.println("Team 2 studentinfo");
        for (String string : team2.studentInfo()) {
            System.out.println(string);
        }

        // x answered correct in question 1
        // x answered correct in question 2
        System.out.println("Team 1 " + Arrays.toString(team1.getAmountCorrectAnswers()));
        System.out.println("Team 2 " + Arrays.toString(team2.getAmountCorrectAnswers()));


    }
}
