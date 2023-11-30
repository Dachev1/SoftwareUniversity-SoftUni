package ProgrammingFundamentals.AssociativeArrays.Exercise;

import java.util.*;

public class P05_Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, List<String>> courseInformation = new LinkedHashMap<>();
        while (true) {
            String input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            }

            String course = input.split(" : ")[0];
            String student = input.split(" : ")[1];

            if (!courseInformation.containsKey(course)) {
                courseInformation.put(course, new ArrayList<>());
            }

            courseInformation.get(course).add(student);
        }

        for (Map.Entry<String, List<String>> kvp : courseInformation.entrySet()) {
            System.out.printf("%s: %d\n", kvp.getKey(), kvp.getValue().size());
            kvp.getValue().forEach(s -> System.out.println("-- " + s));
        }
    }
}
