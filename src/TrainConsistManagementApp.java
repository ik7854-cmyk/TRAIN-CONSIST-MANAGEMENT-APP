import java.util.*;

public class TrainConsistManagementApp {

    // ================= Linear Search Method =================
    public static int linearSearch(String[] bogieIds, String key) {

        for (int i = 0; i < bogieIds.length; i++) {

            // Safe string comparison
            if (bogieIds[i].equals(key)) {
                return i; // match found → return index
            }
        }

        return -1; // not found
    }

    // ================= Main Method =================
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Bogie ID Search (Linear Search) ===");

        // Unsorted array of bogie IDs
        String[] bogieIds = {
                "BG102", "BG305", "BG210", "BG450", "BG120", "BG999"
        };

        System.out.println("Available Bogie IDs:");
        System.out.println(Arrays.toString(bogieIds));

        // User input
        System.out.print("\nEnter Bogie ID to search: ");
        String searchKey = sc.nextLine();

        // Perform search
        int resultIndex = linearSearch(bogieIds, searchKey);

        // Display result
        if (resultIndex != -1) {
            System.out.println("✅ Bogie found at position: " + resultIndex);
        } else {
            System.out.println("❌ Bogie ID not found.");
        }

        System.out.println("\nProgram continues safely 🚆");

        sc.close();
    }
}