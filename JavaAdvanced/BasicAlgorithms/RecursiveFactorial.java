package BasicAlgorithms;

import java.util.Scanner;

public class RecursiveFactorial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(getFactorial(n));
    }

    public static long getFactorial(int n) {

        if (n == 1) {
            return 1;
        }

        if (n == 0) {
            return 0;
        }

        return n * getFactorial(n - 1);
    }
}
