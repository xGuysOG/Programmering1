package model;

import java.util.Arrays;

public class Team {
    private String name;
    private String room;
    private Student[] students;
    private int amountOfStudents;

    private static final String[] answers = {"A", "B", "D", "A", "C", "A", "D", "A", "C", "A"};

    public Team(String name, String room) {
        this.name = name;
        this.room = room;
        students = new Student[32];
        amountOfStudents = 0;
    }

    public int[] correctAnswerCount() {
        int[] correctAnswers = new int[amountOfStudents];
        for (int j = 0; j < amountOfStudents; j++) {
            String[] studentMultipleChoice = students[j].getMultipleChoices();
            for (int i = 0; i < studentMultipleChoice.length; i++) {
                if (studentMultipleChoice[i].equals(answers[i])) {
                    correctAnswers[j]++;
                }
            }
        }
        return correctAnswers;
    }




    public int[] getAmountCorrectAnswers() {
        int[] answerData = new int[answers.length];
        for (int i = 0; i < amountOfStudents; i++) {
            String[] studentMultipleChoice = students[i].getMultipleChoices();
            for (int j = 0; j < studentMultipleChoice.length; j++) {
                if (studentMultipleChoice[j].equals(answers[j])) {
                    answerData[j]++;
                }
            }
        }
        return answerData;
    }

    public int amountCorrectAnswer(int questionNr) {
        return getAmountCorrectAnswers()[questionNr];
    }

    public String[] studentInfo() {
        int[] correctAnswers = correctAnswerCount();
        String[] studentInfo = new String[amountOfStudents];
        for (int i = 0; i < amountOfStudents; i++) {
            studentInfo[i] = "Navn: " + students[i].getName() + " Gennemsnit: " + students[i].getAverageGrade() + " Antal rigtige: " + correctAnswers[i];
        }
        return studentInfo;
    }

    public String getStudentInfo(Student student) {
        String[] answers = getAnswers();
        int correctAnswers = 0;
        for (int i = 0; i < answers.length; i++) {
            if (student.getMultipleChoices()[i] == answers[i]){
                correctAnswers++;
            }
        }
        String studentInfo = "Name: " + student.getName() + ", Grade average: " + student.getAverageGrade()
                + ", Amount of correct answers: " + correctAnswers + "\n";
        return studentInfo;
    }


    public void addStudent(Student student) {
        students[amountOfStudents] = student;
        amountOfStudents++;
    }

    public void removeStudent(String name) {
        amountOfStudents--;
        Student[] studentArray = new Student[32];
        int i = 0;
        for (Student student : students) {
            if (student != null) {
                if (!student.getName().equals(name)) {
                    studentArray[i] = student;
                    i++;
                }
            }
        }
        students = studentArray;
    }

    public void removeStudent2(String name) {
        int i = 0;
        while (students[i] != null && i < amountOfStudents && !students[i].getName().equals(name)) {
            i++;
        }
        if (i < amountOfStudents) {
            for (int j = i; j < amountOfStudents - 1; j++) {
                students[j] = students[j + 1];
            }
            students[amountOfStudents - 1] = null;
            amountOfStudents--;
        }
        //1 2 3 4 5 6 7 8
    }

    public double teamAverageGrades() {
        double teamAverage = 0;
        int amountOfGrades = 0;
        for (int i = 0; i < amountOfStudents; i++) {
            int[] grades = students[i].getGrades();
            for (int j = 0; j < grades.length; j++) {
                teamAverage += grades[j];
                amountOfGrades++;
            }
        }
        teamAverage = teamAverage / amountOfGrades;
        return teamAverage;
    }

    public Student[] highScoreStudents(double minAverage) {
        int goodStudents = 0;
        for (Student student : students) {
            if (student != null) {
                if (student.isActive()) {
                    if (student.getAverageGrade() >= minAverage) {
                        goodStudents++;
                    }
                }
            }
        }
        Student[] highScoreStudents = new Student[goodStudents];
        int index = 0;
        for (Student student : students) {
            if (student != null) {
                if (student.isActive()) {
                    if (student.getAverageGrade() >= minAverage) {
                        highScoreStudents[index] = student;
                        index++;
                    }
                }
            }
        }
        return highScoreStudents;
    }


    public Student[] getStudents() {
        Student[] toReturn = new Student[amountOfStudents];
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                toReturn[i] = students[i];
            }
        }
        return toReturn;
    }

    public String[] getAnswers() {
        return answers;
    }

    public String getName() {
        return this.name;
    }

    public String getRoom() {
        return this.room;
    }

    public int getAmountOfStudents() {
        return this.amountOfStudents;
    }

    @Override
    public String toString() {
        return String.format("Student(name %s, room %s, students %s, amountOfStudents %s)", name, room, Arrays.toString(students), amountOfStudents);
    }

}
