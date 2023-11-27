package ProgrammingFundamentals.ObjectsAndClasses.P05_Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();


        while (true) {
            String input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            }

            String firstName = input.split(" ")[0];
            String lastName = input.split(" ")[1];
            int age = Integer.parseInt(input.split(" ")[2]);
            String hometown = input.split(" ")[3];

            Student student = new Student(firstName, lastName, age, hometown);
            students.add(student);
        }


        String townFilter = scanner.nextLine();

        for (Student student : students) {
            if (student.getHometown().equals(townFilter)) {
                System.out.println(student.getInformation());
            }
        }
    }
}
