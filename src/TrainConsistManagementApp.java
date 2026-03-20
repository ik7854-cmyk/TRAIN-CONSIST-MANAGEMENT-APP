import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Welcome Message
        System.out.println("=== Train Consist Management App ===");

        // === UC1: Initialize Train Consist ===
        List<String> trainConsist = new ArrayList<>();
        System.out.println("Initial bogie count: " + trainConsist.size());

        // === UC2: Add/Remove Passenger Bogies ===
        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");

        System.out.println("\nAfter adding bogies:");
        System.out.println(trainConsist);

        trainConsist.remove("AC Chair");

        System.out.println("\nAfter removing AC Chair:");
        System.out.println(trainConsist);

        boolean isSleeperPresent = trainConsist.contains("Sleeper");
        System.out.println("\nIs 'Sleeper' present? " + isSleeperPresent);

        System.out.println("\nFinal train consist:");
        System.out.println(trainConsist);

        // === UC3: Ensure Unique Bogie IDs using HashSet ===
        Set<String> bogieIds = new HashSet<>();

        // Adding bogie IDs (including duplicates)
        bogieIds.add("B101");
        bogieIds.add("B102");
        bogieIds.add("B103");
        bogieIds.add("B101"); // duplicate
        bogieIds.add("B102"); // duplicate

        System.out.println("\nUnique Bogie IDs (duplicates ignored):");
        System.out.println(bogieIds);

        // Program continues...
    }
}