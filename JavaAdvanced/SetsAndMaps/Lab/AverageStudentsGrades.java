import java.util.*;
import java.util.stream.Collectors;

public class AverageStudentsGrades {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> studentsData = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double grade = Double.parseDouble(tokens[1]);

            studentsData.putIfAbsent(name, new ArrayList<>());
            studentsData.get(name).add(grade);
        }

        studentsData.forEach((k, v) -> {
            String grades = v.stream().map(g -> String.format("%.2f", g))
                    .collect(Collectors.joining(" "));

            double avgGrade = 0;
            for (Double currentGrade : v) {
                avgGrade += currentGrade;
            }

            avgGrade /= v.size();

            System.out.printf("%s -> %s (avg: %.2f)\n", k, grades, avgGrade);

        });
    }
}
