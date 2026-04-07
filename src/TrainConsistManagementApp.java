import java.util.*;

public class TrainConsistManagementApp {

    // ================= Bubble Sort Method =================
    public static void bubbleSort(int[] capacities) {

        int n = capacities.length;

        // Outer loop → number of passes
        for (int i = 0; i < n - 1; i++) {

            // Inner loop → compare adjacent elements
            for (int j = 0; j < n - i - 1; j++) {

                // If current element > next element → swap
                if (capacities[j] > capacities[j + 1]) {

                    // Swapping logic
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }
    }

    // ================= Main Method =================
    public static void main(String[] args) {

        System.out.println("=== Passenger Bogie Capacity Sorting (Bubble Sort) ===");

        // Sample passenger bogie capacities
        int[] capacities = {72, 50, 78, 24, 60, 90, 45};

        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(capacities));

        // Call Bubble Sort
        bubbleSort(capacities);

        System.out.println("\nAfter Sorting:");
        System.out.println(Arrays.toString(capacities));

        System.out.println("\nProgram completed successfully 🚆");
    }
}