package ProgrammingFundamentals.AssociativeArrays;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P01_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(e -> Double.parseDouble(e))
                .toArray();

        TreeMap<Double, Integer> map = new TreeMap<>();

        for (double num : numbers) {
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }

            map.put(num, map.get(num) + 1);
        }

        DecimalFormat df = new DecimalFormat("#.######");
        for (Map.Entry<Double, Integer> kvp : map.entrySet()) {

            System.out.printf("%s -> %d\n", df.format(kvp.getKey()), kvp.getValue());
        }
    }
}
