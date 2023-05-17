import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class SeatingGenerator {

    private static final String OLD_GROUPS_FILE = "C:\\Users\\uhrsk.MSI\\Desktop\\old_groups.json";
    private static final String STUDENTS_FILE = "C:\\Users\\uhrsk.MSI\\Desktop\\students.json";
    public static void main(String[] args) {
        //doing all the student stuff first
        Scanner input = new Scanner(System.in);
        boolean fileExists = Files.exists(Path.of(STUDENTS_FILE));

        // Load the list of students from the file or prompt the user to enter a new list
        ArrayList<String> students = loadStudents();
        if (students == null || !fileExists) {
            System.out.println("Please enter a list of students, separated by commas:");
            String studentsInput = input.nextLine();
            students.clear();
            String[] students1 = studentsInput.split(",");
            for (String student : students) {
                students.add(student);
            }

        } else {
            // If the file exists, show the existing list of students and ask the user if they want to replace it
            System.out.println("Existing list of students:");
            for (String student : students) {
                System.out.println("- " + student);
            }
            System.out.println("Do you want to replace the existing list of students? (y/n)");
            String replaceInput = input.nextLine();
            if (replaceInput.equalsIgnoreCase("y")) {
                System.out.println("Please enter a new list of students, separated by commas:");
                String studentsInput = input.nextLine();
                students.clear();
                String[] students1 = studentsInput.split(",");
                for (String student : students) {
                    students.add(student);
                }
            }
        }

        saveStudents(students);
        //then we do groups

        Set<String> oldGroups = loadOldGroups();
        while (true) {
            System.out.print("Enter an old seating group (or 'done' to finish): ");
            String oldGroup = input.nextLine();
            if (oldGroup.equals("done")) {
                break;
            }
            oldGroups.add(oldGroup);
        }
        saveOldGroups(oldGroups);




    }

    private static List<List<String>> generateSeating(ArrayList<String> students, Set<String> oldGroups, int preferredGroupSize) {
        List<List<String>> seating = new ArrayList<>();

        // Shuffle the list of students to generate random seating
        Collections.shuffle(students);

        for (int i = 0; i < students.size(); i += preferredGroupSize) {
            // Calculate the size of the current group (can be smaller if there are not enough students left)
            int groupSize = Math.min(preferredGroupSize, students.size() - i);

            // Create the new group and add students to it
            List<String> newGroup = new ArrayList<>();
            for (int j = i; j < i + groupSize; j++) {
                String student = students.get(j);
                // Check if the student has sat with any other student in the current group or any student in an old group
//                if (hasSatWithAny(student, seating) || hasSatWithAny(student, oldGroups)) {
//                    // If the student has sat with someone else in the current group or any old group, remove the student from the group
//                    newGroup.remove(student);
//                    // Re-add the removed students to the list of students at the same index
//                    students.add(j, student);
//                    j--;
//                    groupSize--;
//                    continue;
//                }
                newGroup.add(student);
            }
            seating.add(newGroup);
        }
        return seating;
    }


    private static boolean hasSatWithAny(String student, List<List<String>> groups) {
        for (List<String> group : groups) {
            if (group.contains(student)) {
                return true;
            }
        }
        return false;
    }

    private static Set<String> loadOldGroups() {
        Set<String> oldGroups = new HashSet<>();
        File file = new File(OLD_GROUPS_FILE);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                Gson gson = new Gson();
                TypeToken<Set<String>> token = new TypeToken<Set<String>>(){};
                oldGroups = gson.fromJson(reader, token.getType());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return oldGroups;
    }

    private static void saveOldGroups(Set<String> oldGroups) {
        try (Writer writer = new FileWriter(OLD_GROUPS_FILE)) {
            Gson gson = new Gson();
            gson.toJson(oldGroups, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<String> loadStudents() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(STUDENTS_FILE)) {
            String[] studentArray = gson.fromJson(reader, String[].class);
            return new ArrayList<String>(Arrays.asList(studentArray));
        } catch (IOException e) {
            System.err.println("Error loading students from file: " + e.getMessage());
            return null;
        }
    }

    private static void saveStudents(ArrayList<String> students) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(STUDENTS_FILE)) {
            gson.toJson(students.toArray(new String[students.size()]), writer);
            System.out.println("Successfully saved students to file.");
        } catch (IOException e) {
            System.err.println("Error saving students to file: " + e.getMessage());
        }
    }

}

//    public static Map<String, Set<String>> generateSeating(List<String> students, Set<String> oldGroups) {
//        Map<String, Set<String>> seating = new HashMap<>();
//        Set<String> usedStudents = new HashSet<>();
//        for (int i = 1; i <= 5; i++) {
//            String group = "Group " + i;
//            Set<String> groupMembers = new HashSet<>();
//            while (groupMembers.size() < 6) {
//                List<String> availableStudents = new ArrayList<>(students);
//                availableStudents.removeAll(usedStudents);
//                for (String oldGroup : oldGroups) {
//                    List<String> oldGroupMembers = Arrays.asList(oldGroup.split(", "));
//                    if (groupMembers.containsAll(oldGroupMembers)) {
//                        availableStudents.removeAll(oldGroupMembers);
//                    }
//                }
//                if (availableStudents.isEmpty()) {
//                    throw new RuntimeException("Failed to generate seating - not enough available students.");
//                }
//                Collections.shuffle(availableStudents);
//                String student = availableStudents.get(0);
//                groupMembers.add(student);
//                usedStudents.add(student);
//            }
//            seating.put(group, groupMembers);
//        }
//        return seating;
//    }
