package ProgrammingFundamentals.AssociativeArrays.Exercise.MoreExercise;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class P02_Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, HashMap<String, Integer>> storedValues = new LinkedHashMap<>();

        while (true) {
            String line = scanner.nextLine();

            if (line.equals("no more time")) {
                break;
            }

            String[] data = line.split(" -> ");
            String username = data[0];
            String contest = data[1];
            int points = Integer.parseInt(data[2]);

            if (!storedValues.containsKey(contest)) {
                storedValues.put(contest, new HashMap<>());
                storedValues.get(contest).put(username, points);
            } else {
                if (storedValues.get(contest).containsKey(username)) {
                    if (points > storedValues.get(contest).get(username)) {
                        storedValues.get(contest).put(username, points);
                    }
                } else {
                    storedValues.get(contest).put(username, points);
                }
            }
        }

        print(storedValues);
    }

    private static void print(LinkedHashMap<String, HashMap<String, Integer>> contests) {
        AtomicInteger num = new AtomicInteger();
        contests.forEach((k, v) -> {
            num.set(0);
            System.out.printf("%s: %d participants%n", k, v.size());
            v.entrySet()
                    .stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue()
                            .reversed()
                            .thenComparing(Map.Entry.comparingByKey()))

                    .forEach(e -> System.out.printf("%d. %s <::> %d%n", num.incrementAndGet(),
                            e.getKey(), e.getValue()));
        });

        System.out.println("Individual standings:");

        Map<String, Integer> results = new LinkedHashMap<>();

        for (Map.Entry<String, HashMap<String, Integer>> entry : contests.entrySet()) {
            for (Map.Entry<String, Integer> mapEntry : entry.getValue().entrySet()) {
                results.putIfAbsent(mapEntry.getKey(), 0);
                results.put(mapEntry.getKey(), results.get(mapEntry.getKey()) + mapEntry.getValue());
            }
        }

        num.set(0);
        results.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(e -> System.out.printf("%d. %s -> %d%n", num.incrementAndGet(), e.getKey(), e.getValue()));
    }
}


