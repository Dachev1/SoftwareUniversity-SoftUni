package DefiningClasses.Exercise.CompanyRoster;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        Department departments = new Department(count);

        while (count-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            Employee employee;

            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];

            switch (tokens.length) {
                case 4:
                    employee = new Employee(name, salary, position, department);
                    break;

                case 5:
                    if (tokens[4].matches("\\d+")) {
                        employee = new Employee(name, salary, position, department, Integer.parseInt(tokens[4]));
                    } else {
                        employee = new Employee(name, salary, position, department, tokens[4]);
                    }
                    break;

                default:
                    employee = new Employee(name, salary, position, department, tokens[4],  Integer.parseInt(tokens[5]));
                    break;
            }

            departments.add(employee);
        }

        departments.getDepartmentHighestAverageSalary();
    }
}
