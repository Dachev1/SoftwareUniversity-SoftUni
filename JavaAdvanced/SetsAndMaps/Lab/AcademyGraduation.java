import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> studentsData = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            List<Double> grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());

            double avgGrade = grades.stream().mapToDouble(g -> g).sum() / grades.size();

            studentsData.put(name, avgGrade);
        }

        studentsData.forEach((k, v) -> {
            BigDecimal bigDecimal = new BigDecimal(v);
            System.out.printf("%s is graduated with %s\n", k, bigDecimal.stripTrailingZeros().toPlainString());
        });
    }
}
