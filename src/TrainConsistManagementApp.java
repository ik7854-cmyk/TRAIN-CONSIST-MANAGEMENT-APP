import java.util.*;
import java.util.stream.Collectors;

// ================= Custom Checked Exception =================
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// ================= Custom Runtime Exception =================
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

// ================= Bogie Class =================
class Bogie {
    String name;
    int capacity;
    String shape; // RECTANGULAR / CYLINDRICAL
    String cargo; // Assigned cargo

    Bogie(String name, int capacity, String shape) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Invalid capacity for bogie: " + name);
        }
        this.name = name;
        this.capacity = capacity;
        this.shape = shape;
    }

    // ================= Cargo Assignment =================
    void assignCargo(String cargoType) {
        try {
            System.out.println("\nAssigning cargo: " + cargoType + " to " + name);

            // Safety Rule
            if (cargoType.equalsIgnoreCase("Petroleum") &&
                    shape.equalsIgnoreCase("Rectangular")) {

                throw new CargoSafetyException(
                        "Unsafe cargo! Petroleum cannot be loaded in Rectangular bogie: " + name
                );
            }

            this.cargo = cargoType;
            System.out.println("Cargo assigned successfully ✅");

        } catch (CargoSafetyException e) {
            System.out.println("ERROR: " + e.getMessage());

        } finally {
            System.out.println("Logging: Cargo assignment attempted for " + name);
        }
    }
}

// ================= Main Application =================
public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        List<Bogie> bogieList = new ArrayList<>();

        // Creating dataset safely
        for (int i = 0; i < 5; i++) {
            try {
                bogieList.add(new Bogie("Sleeper", 72, "Rectangular"));
                bogieList.add(new Bogie("Tanker", 50, "Cylindrical"));
                bogieList.add(new Bogie("AC Chair", 78, "Rectangular"));

            } catch (InvalidCapacityException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        // ================= Cargo Assignment Demo =================
        for (Bogie b : bogieList) {
            b.assignCargo("Petroleum"); // will fail for rectangular
        }

        // ================= Performance Comparison =================
        long startLoop = System.nanoTime();

        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : bogieList) {
            if (b.capacity > 60) {
                loopFiltered.add(b);
            }
        }

        long endLoop = System.nanoTime();

        long startStream = System.nanoTime();

        List<Bogie> streamFiltered = bogieList.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        long endStream = System.nanoTime();

        System.out.println("\nPerformance Comparison:");
        System.out.println("Loop Time   : " + (endLoop - startLoop) + " ns");
        System.out.println("Stream Time : " + (endStream - startStream) + " ns");

        System.out.println("\nProgram completed safely 🚆");
    }
}