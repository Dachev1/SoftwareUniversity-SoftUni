import java.util.*;
import java.util.stream.Collectors;

public class CountRealNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Double, Integer> numberCounter = new LinkedHashMap<>();

        List<Double> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        for (Double num : numbers) {
            numberCounter.putIfAbsent(num, 0);
            int newCount = numberCounter.get(num) + 1;
            numberCounter.put(num, newCount);
        }

        numberCounter.forEach((k, v) -> {
            System.out.printf("%.1f -> %d\n", k, v);
        });
    }
}
