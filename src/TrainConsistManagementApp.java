import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

// Passenger Bogie Class
class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    void display() {
        System.out.println(name + " -> Capacity: " + capacity);
    }
}

// Goods Bogie Class
class GoodsBogie {
    String type;
    String cargo;

    GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    void display() {
        System.out.println(type + " -> Cargo: " + cargo);
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Train Consist Management App ===");

        // === UC7–UC10 (same as before, shortened here if needed) ===
        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 78));
        bogieList.add(new Bogie("First Class", 24));

        // === UC11: Regex Validation ===
        System.out.print("\nEnter Train ID (Format: TRN-1234): ");
        String trainId = sc.nextLine();

        Pattern trainPattern = Pattern.compile("TRN-\\d{4}");
        if (!trainPattern.matcher(trainId).matches()) {
            System.out.println("Invalid Train ID ❌");
        } else {
            System.out.println("Valid Train ID ✅");
        }

        // === UC12: Safety Validation using allMatch ===

        // Create goods bogies
        List<GoodsBogie> goodsList = new ArrayList<>();

        goodsList.add(new GoodsBogie("Cylindrical", "Petroleum")); // valid
        goodsList.add(new GoodsBogie("Box", "Grains"));            // valid
        goodsList.add(new GoodsBogie("Cylindrical", "Water"));     // invalid case

        // Display goods bogies
        System.out.println("\nGoods Bogie Details:");
        for (GoodsBogie g : goodsList) {
            g.display();
        }

        // Apply safety rule using allMatch
        boolean isSafe = goodsList.stream()
                .allMatch(g ->
                        !g.type.equalsIgnoreCase("Cylindrical") ||
                                g.cargo.equalsIgnoreCase("Petroleum")
                );

        // Display result
        System.out.println("\nSafety Validation Result:");
        if (isSafe) {
            System.out.println("Train is SAFE ✅");
        } else {
            System.out.println("Train is NOT SAFE ❌");
        }

        sc.close();
    }
}