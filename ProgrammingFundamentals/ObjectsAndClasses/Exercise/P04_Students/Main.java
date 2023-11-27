package ProgrammingFundamentals.ObjectsAndClasses.Exercise.P04_Students;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Collegian> collegians = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String[] inputArgs = scanner.nextLine().split(" ");
            String firstName = inputArgs[0];
            String lastName = inputArgs[1];
            double grade = Double.parseDouble(inputArgs[2]);

            Collegian collegian = new Collegian(firstName, lastName, grade);
            collegians.add(collegian);
        }


        Collections.sort(collegians, Comparator.comparingDouble(Collegian::getGrade).reversed());

        for (Collegian collegian : collegians) {
            System.out.printf("%s %s: %.2f\n",
                    collegian.getFirstName(),
                    collegian.getLastName(),
                    collegian.getGrade());
        }
    }
}
