package model;

import java.util.Arrays;

public class Student {

    //10, 2
    //spørgsmål, svar
    //sprøgsmål1, C
    private String name;
    private boolean active;
    private int[] grades;

    private String[] multipleChoice;

    public Student(String name, boolean active, int[] grades) {
        this.name = name;
        this.active = active;
        this.grades = grades;
        this.multipleChoice = new String[10];
        generateMultipleChoiceAnswers();
    }

    public void generateMultipleChoiceAnswers() {
        for (int row = 0; row < multipleChoice.length; row++) {
            multipleChoice[row] = randomAnswer();
        }
    }

    public String randomAnswer() {
        int answer = (int) (Math.random() * 4 + 1);
        String result;
        if (answer == 1) {
            result = "A";
        } else if (answer == 2) {
            result = "B";
        } else if (answer == 3) {
            result = "C";
        } else {
            result = "D";
        }
        return result;
    }

    public int getHighestGrade() {
        int highest = 0;
        for (int i = 0; grades.length > i; i++) {
            if (grades[i] >= highest) {
                highest = grades[i];
            }
        }
        return highest;
    }

    public double getAverageGrade() {
        double averageGrade = 0;
        for (int grade : grades) {
            averageGrade += grade;
        }
        averageGrade = averageGrade / grades.length;
        return averageGrade;
    }

    public String getName() {
        return this.name;
    }

    public boolean isActive() {
        return this.active;
    }

    public int[] getGrades() {
        return this.grades;
    }

    public String[] getMultipleChoices() {
        return multipleChoice;
    }

    @Override
    public String toString() {
        return String.format("Student(name %s, active %s, grades %s, averageGrade %s, highestGrade %s, multipleChoiceAnswers %s)", name, active, Arrays.toString(grades), getAverageGrade(), getHighestGrade(), Arrays.toString(multipleChoice));
    }
}
