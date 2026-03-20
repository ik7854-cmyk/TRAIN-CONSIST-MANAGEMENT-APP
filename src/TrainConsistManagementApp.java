import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Welcome Message
        System.out.println("=== Train Consist Management App ===");

        // Initialize Train Consist
        List<String> trainConsist = new ArrayList<>();

        // Initial Count
        System.out.println("Initial bogie count: " + trainConsist.size());

        // === UC2: Add Passenger Bogies ===
        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");

        // Display after insertion
        System.out.println("\nAfter adding bogies:");
        System.out.println(trainConsist);

        // Remove a bogie (AC Chair)
        trainConsist.remove("AC Chair");

        // Display after removal
        System.out.println("\nAfter removing AC Chair:");
        System.out.println(trainConsist);

        // Check existence of "Sleeper"
        boolean isSleeperPresent = trainConsist.contains("Sleeper");
        System.out.println("\nIs 'Sleeper' present? " + isSleeperPresent);

        // Final state
        System.out.println("\nFinal train consist:");
        System.out.println(trainConsist);

        // Program continues...
    }
}