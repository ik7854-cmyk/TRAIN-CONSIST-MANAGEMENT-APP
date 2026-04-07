import java.util.*;
import java.util.stream.Collectors;

// Custom Exception Class
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// Bogie Class
class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) throws InvalidCapacityException {
        // Fail-Fast Validation
        if (capacity <= 0) {
            throw new InvalidCapacityException("Invalid capacity for bogie: " + name);
        }
        this.name = name;
        this.capacity = capacity;
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        List<Bogie> bogieList = new ArrayList<>();

        // Creating dataset safely
        for (int i = 0; i < 100000; i++) {
            try {
                bogieList.add(new Bogie("Sleeper", 72));
                bogieList.add(new Bogie("AC Chair", 78));
                bogieList.add(new Bogie("First Class", 24));

                // Example invalid case (uncomment to test)
                // bogieList.add(new Bogie("Invalid", 0));

            } catch (InvalidCapacityException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        // === Loop-Based Filtering ===
        long startLoop = System.nanoTime();

        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : bogieList) {
            if (b.capacity > 60) {
                loopFiltered.add(b);
            }
        }

        long endLoop = System.nanoTime();
        long loopTime = endLoop - startLoop;

        // === Stream-Based Filtering ===
        long startStream = System.nanoTime();

        List<Bogie> streamFiltered = bogieList.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        long endStream = System.nanoTime();
        long streamTime = endStream - startStream;

        // === Results ===
        System.out.println("\nPerformance Comparison:");
        System.out.println("Loop Filtering Time   : " + loopTime + " ns");
        System.out.println("Stream Filtering Time : " + streamTime + " ns");

        if (loopTime < streamTime) {
            System.out.println("Loop is faster in this run ⚡");
        } else {
            System.out.println("Stream is faster in this run ⚡");
        }

        System.out.println("\nProgram completed safely.");
    }
}