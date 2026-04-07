import java.util.*;

// Bogie Class (Custom Object)
class Bogie {
    String name;
    int capacity;

    // Constructor
    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    // Display method
    void display() {
        System.out.println(name + " -> Capacity: " + capacity);
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Welcome Message
        System.out.println("=== Train Consist Management App ===");

        // === UC6: HashMap (Bogie → Capacity Mapping) ===
        HashMap<String, Integer> bogieCapacityMap = new HashMap<>();

        bogieCapacityMap.put("Sleeper", 72);
        bogieCapacityMap.put("AC Chair", 78);
        bogieCapacityMap.put("First Class", 24);

        System.out.println("\nBogie Capacity Details (HashMap):");

        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            System.out.println(entry.getKey() + " -> Capacity: " + entry.getValue());
        }

        // === UC7: Sorting Bogies using Comparator ===

        // Create List of Bogie objects
        List<Bogie> bogieList = new ArrayList<>();

        // Add bogies
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 78));
        bogieList.add(new Bogie("First Class", 24));

        // Sort using Comparator (by capacity)
        bogieList.sort(Comparator.comparingInt(b -> b.capacity));

        // Display sorted bogies
        System.out.println("\nSorted Bogies by Capacity:");

        for (Bogie b : bogieList) {
            b.display();
        }

        // Program continues...
    }
}