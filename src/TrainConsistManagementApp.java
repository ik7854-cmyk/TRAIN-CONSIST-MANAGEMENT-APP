import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Welcome Message
        System.out.println("=== Train Consist Management App ===");

        // === UC1: Initialize Train Consist ===
        List<String> trainConsist = new ArrayList<>();
        System.out.println("Initial bogie count: " + trainConsist.size());

        // === UC2: ArrayList Operations ===
        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");

        System.out.println("\nAfter adding bogies:");
        System.out.println(trainConsist);

        trainConsist.remove("AC Chair");

        System.out.println("\nAfter removing AC Chair:");
        System.out.println(trainConsist);

        System.out.println("\nIs 'Sleeper' present? " + trainConsist.contains("Sleeper"));

        // === UC3: HashSet for Unique Bogie IDs ===
        Set<String> bogieIds = new HashSet<>();
        bogieIds.add("B101");
        bogieIds.add("B102");
        bogieIds.add("B103");
        bogieIds.add("B101"); // duplicate

        System.out.println("\nUnique Bogie IDs:");
        System.out.println(bogieIds);

        // === UC4: LinkedList for Train Structure ===
        LinkedList<String> train = new LinkedList<>();

        // Add bogies
        train.add("Engine");
        train.add("Sleeper");
        train.add("AC");
        train.add("Cargo");
        train.add("Guard");

        System.out.println("\nInitial train consist:");
        System.out.println(train);

        // Insert Pantry Car at position 2
        train.add(2, "Pantry Car");

        System.out.println("\nAfter inserting Pantry Car at position 2:");
        System.out.println(train);

        // Remove first and last bogie
        train.removeFirst();
        train.removeLast();

        // Final state
        System.out.println("\nFinal train consist after removing first and last bogies:");
        System.out.println(train);

        // Program continues...
    }
}