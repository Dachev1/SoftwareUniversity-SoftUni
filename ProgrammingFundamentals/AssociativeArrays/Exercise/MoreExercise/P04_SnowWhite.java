package ProgrammingFundamentals.AssociativeArrays.Exercise.MoreExercise;

import java.util.*;

public class P04_SnowWhite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Long> dwarf = new LinkedHashMap<>();

        String input;
        while (!"Once upon a time".equals(input = scanner.nextLine())) {

            String[] data = input.split(" <:> ");
            String name = data[0];
            String color = data[1];
            String nameColor = String.join(" ", color, name);
            long physic = Long.parseLong(data[2]);

            dwarf.putIfAbsent(nameColor, 0L);

            if (dwarf.get(nameColor) < physic) {
                dwarf.put(nameColor, physic);
            }

        }

        dwarf.entrySet().stream().sorted((d1, d2) -> {

            Long d1physic = d1.getValue();
            Long d2physic = d2.getValue();

            if (d1physic.compareTo(d2physic) == 0) {
                String colorD1 = d1.getKey().split(" ")[0];
                String colorD2 = d2.getKey().split(" ")[0];
                long countColorD1 = dwarf.entrySet().stream().filter(entry -> entry.getKey().split(" ")[0].equals(colorD1)).count();
                long countColorD2 = dwarf.entrySet().stream().filter(entry -> entry.getKey().split(" ")[0].equals(colorD2)).count();

                return Long.compare(countColorD2, countColorD1);
            }
            return Long.compare(d2physic, d1physic);
        }).forEach(d -> {
            String color = d.getKey().split(" ")[0];
            String name = d.getKey().split(" ")[1];
            Long physic = d.getValue();

            System.out.printf("(%s) %s <-> %d%n", color, name, physic);
        });

    }
}

