import java.util.*;

public class TrainConsistManagementApp {

    // ================= Binary Search Method =================
    public static int binarySearch(String[] bogieIds, String key) {

        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int comparison = key.compareTo(bogieIds[mid]);

            if (comparison == 0) {
                return mid; // found
            } else if (comparison > 0) {
                low = mid + 1; // search right half
            } else {
                high = mid - 1; // search left half
            }
        }

        return -1; // not found
    }

    // ================= Main Method =================
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Bogie ID Search (Binary Search) ===");

        // MUST be sorted
        String[] bogieIds = {
                "BG102", "BG120", "BG210", "BG305", "BG450", "BG999"
        };

        System.out.println("Sorted Bogie IDs:");
        System.out.println(Arrays.toString(bogieIds));

        // User input
        System.out.print("\nEnter Bogie ID to search: ");
        String key = sc.nextLine();

        // Perform search
        int result = binarySearch(bogieIds, key);

        // Display result
        if (result != -1) {
            System.out.println("✅ Bogie found at index: " + result);
        } else {
            System.out.println("❌ Bogie ID not found.");
        }

        System.out.println("\nProgram continues safely 🚆");

        sc.close();
    }
}