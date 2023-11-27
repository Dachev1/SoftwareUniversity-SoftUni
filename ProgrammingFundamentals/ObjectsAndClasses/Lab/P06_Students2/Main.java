package ProgrammingFundamentals.ObjectsAndClasses.P06_Students2;

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

            boolean isExists = false;
            isExists = studentExists(students, firstName, lastName, age, hometown, isExists);

            if (!isExists) {
                Student student = new Student(firstName, lastName, age, hometown);
                students.add(student);
            }
        }


        String townFilter = scanner.nextLine();

        for (Student student : students) {
            if (student.getHometown().equals(townFilter)) {
                System.out.println(student.getInformation());
            }
        }
    }

    private static boolean studentExists(List<Student> students, String firstName, String lastName, int age, String hometown, boolean isExists) {
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                student.setAge(age);
                student.setHometown(hometown);

                isExists = true;
            }
        }
        return isExists;
    }
}
