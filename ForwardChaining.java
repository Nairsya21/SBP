import java.util.*;

public class ForwardChaining {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input fakta awal
        System.out.println("Masukkan jumlah fakta awal:");
        int numFacts = scanner.nextInt();
        scanner.nextLine(); 
        Set<String> facts = new HashSet<>();
        System.out.println("Masukkan fakta awal (misal: A):");
        for (int i = 0; i < numFacts; i++) {
            facts.add(scanner.nextLine());
        }

        // Proses forward chaining
        boolean updated = true;
        while (updated) {
            updated = false;
            for (String fact : new HashSet<>(facts)) {
                if (applyRules(fact, facts)) {
                    updated = true;
                }
            }
        }

        // Menampilkan hasil
        String lastFact = "";
        for (String fact : facts) {
            lastFact = fact;
        }
        System.out.println("Fakta terakhir: " + lastFact);

        scanner.close();
    }

    public static boolean applyRules(String fact, Set<String> facts) {
        boolean updated = false;
        if (facts.contains("A") && facts.contains("B")) {
            if (!facts.contains("C")) {
                facts.add("C");
                updated = true;
            }
        }
        if (facts.contains("A") && facts.contains("E")) {
            if (!facts.contains("F")) {
                facts.add("F");
                updated = true;
            }
        }
        if (facts.contains("F") && facts.contains("G")) {
            if (!facts.contains("D")) {
                facts.add("D");
                updated = true;
            }
        }
        if (facts.contains("G") && facts.contains("E")) {
            if (!facts.contains("H")) {
                facts.add("H");
                updated = true;
            }
        }
        if (facts.contains("C") && facts.contains("H")) {
            if (!facts.contains("I")) {
                facts.add("I");
                updated = true;
            }
        }
        if (facts.contains("I") && facts.contains("A")) {
            if (!facts.contains("J")) {
                facts.add("J");
                updated = true;
            }
        }

        switch (fact) {
            case "A":
                if (!facts.contains("G")) {
                    facts.add("G");
                    updated = true;
                }
                break;
            case "C":
                if (!facts.contains("D")) {
                    facts.add("D");
                    updated = true;
                }
                break;
            
            case "G":
                if (!facts.contains("J")) {
                    facts.add("J");
                    updated = true;
                }
                break;
            case "J":
                if (!facts.contains("K")) {
                    facts.add("K");
                    updated = true;
                }
                break;
        }
        return updated;
    }
}
