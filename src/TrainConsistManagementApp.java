import java.util.*;

public class TrainConsistManagementApp {

    // ================= Binary Search Method =================
    public static int binarySearch(String[] bogieIds, String key) {


        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException(
                    " Cannot perform search: No bogies available in the train."
            );
        }

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


        String[] bogieIds = {
                "BG102", "BG120", "BG210", "BG305", "BG450", "BG999"
        };

        System.out.println("Sorted Bogie IDs:");
        System.out.println(Arrays.toString(bogieIds));

        // User input
        System.out.print("\nEnter Bogie ID to search: ");
        String key = sc.nextLine();

        try {

            int result = binarySearch(bogieIds, key);

            if (result != -1) {
                System.out.println("Bogie found at index: " + result);
            } else {
                System.out.println(" Bogie ID not found.");
            }

        } catch (IllegalStateException e) {

            System.out.println(e.getMessage());
        }

        System.out.println("\nProgram ends safely ");

        sc.close();
    }
}