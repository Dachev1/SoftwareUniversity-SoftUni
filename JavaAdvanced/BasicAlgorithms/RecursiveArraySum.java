package BasicAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class RecursiveArraySum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(arrSum(arr, 0));
    }

    public static int arrSum(int[] arr, int index) {

        if (index >= arr.length) {
            return 0;
        }

        return arr[index] + arrSum(arr, index + 1);
    }
}
