package ProgrammingFundamentals.AssociativeArrays.Exercise;

import java.util.*;

public class P08_CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, List<String>> companyEmployees = new LinkedHashMap<>();
        while (true) {
            String input = scanner.nextLine();

            if (input.equals("End")) {
                break;
            }

            String[] inputArgs = input.split(" -> ");

            String company = inputArgs[0];
            String id = inputArgs[1];

                companyEmployees.putIfAbsent(company, new ArrayList<>());
                if (!companyEmployees.get(company).contains(id)) {
                    companyEmployees.get(company).add(id);
                }
        }

        for (Map.Entry<String, List<String>> kvp : companyEmployees.entrySet()) {
            System.out.println(kvp.getKey());
            kvp.getValue().forEach(s -> System.out.println("-- " + s));
        }
    }
}
