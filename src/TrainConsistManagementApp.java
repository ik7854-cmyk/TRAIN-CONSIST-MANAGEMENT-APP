import java.util.*;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== Bogie Type Sorting (Arrays.sort) ===");

        // Array of bogie type names
        String[] bogieTypes = {
                "Sleeper",
                "AC Chair",
                "First Class",
                "General",
                "Tanker",
                "Luxury",
                "Metro"
        };

        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(bogieTypes));

        // Built-in sorting
        Arrays.sort(bogieTypes);

        System.out.println("\nAfter Sorting (Alphabetical):");
        System.out.println(Arrays.toString(bogieTypes));

        System.out.println("\nProgram completed successfully 🚆");
    }
}