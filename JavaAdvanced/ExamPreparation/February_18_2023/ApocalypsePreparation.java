package ExamPreparation.February_18_2023;

import java.util.*;

public class ApocalypsePreparation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> textiles = new ArrayDeque<>(); // queue
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(textiles::offer);

        Deque<Integer> medicaments = new ArrayDeque<>(); // stack
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(medicaments::push);

        int patchCount = 0;
        int bandageCount = 0;
        int medKitCount = 0;

        while (!textiles.isEmpty() && !medicaments.isEmpty()) {
            int textile = textiles.poll();
            int medicament = medicaments.pop();
            int sum = textile + medicament;

            switch (sum) {
                case 30:
                    patchCount++;
                    break;
                case 40:
                    bandageCount++;
                    break;
                case 100:
                    medKitCount++;
                    break;
                default:
                    int updateValueOfNextMedicament = 0;
                    if (sum > 100) {
                        medKitCount++;
                        sum -= 100;
                        updateValueOfNextMedicament = medicaments.pop() + sum;
                    } else {
                        updateValueOfNextMedicament = medicament + 10;
                    }

                    medicaments.push(updateValueOfNextMedicament);
                    break;
            }
        }

        print(textiles, medicaments, patchCount, bandageCount, medKitCount);
    }

    private static void print(Deque<Integer> textiles, Deque<Integer> medicaments, int patchCount, int bandageCount, int medKitCount) {
        Map<String, Integer> items = new TreeMap<>();
        items.put("Patch", patchCount);
        items.put("Bandage", bandageCount);
        items.put("MedKit", medKitCount);

        SortedSet<Map.Entry<String, Integer>> sortedSet = new TreeSet<>(new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o2.getValue().compareTo(o1.getValue()) == 0) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        sortedSet.addAll(items.entrySet());

        if (textiles.isEmpty() && medicaments.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        } else if (textiles.isEmpty()) {
            System.out.println("Textiles are empty.");
        } else {
            System.out.println("Medicaments are empty.");
        }

        for (Map.Entry<String, Integer> map : sortedSet) {
            if (map.getValue() != 0) {
                System.out.printf("%s - %d\n", map.getKey(), map.getValue());
            }
        }

        if (!medicaments.isEmpty()) {
            System.out.println("Medicaments left: " + medicaments.toString().replaceAll("[\\[\\]]", ""));
        }

        if (!textiles.isEmpty()) {
            System.out.println("Textiles left: " + textiles.toString().replaceAll("[\\[\\]]", ""));
        }
    }
}
