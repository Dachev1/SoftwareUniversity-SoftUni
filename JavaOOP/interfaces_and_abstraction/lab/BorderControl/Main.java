package interfaces_and_abstraction.lab.BorderControl;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Identifiable> cityInfo = new LinkedHashMap<>();

        String line;
        while (!"End".equals(line = scanner.nextLine())) {
            String[] lineArgs = line.split("\\s+");

            if (lineArgs.length == 3) {
                Citizen citizen = new Citizen(lineArgs[0], Integer.parseInt(lineArgs[1]), lineArgs[2]);
                cityInfo.put(lineArgs[2], citizen);
            } else if (lineArgs.length == 2) {
                Robot robot = new Robot(lineArgs[0], lineArgs[1]);
                cityInfo.put(lineArgs[1], robot);
            }
        }

        String lastIdsNumbers = scanner.nextLine();

        for (Map.Entry<String, Identifiable> entry : cityInfo.entrySet()) {
            if (entry.getKey().endsWith(lastIdsNumbers)) {
                System.out.println(entry.getKey());
            }
        }
    }
}
