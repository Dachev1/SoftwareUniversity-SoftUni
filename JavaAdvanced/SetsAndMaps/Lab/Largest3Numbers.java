import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Largest3Numbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Collections.sort(numbers);
        Collections.reverse(numbers);
        numbers = numbers.stream().limit(3).collect(Collectors.toList());;

        numbers.forEach(n -> System.out.print(n + " "));
    }
}
