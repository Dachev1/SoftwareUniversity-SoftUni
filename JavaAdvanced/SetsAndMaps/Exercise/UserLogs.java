package SetsAndMaps.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class UserLogs {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> usersData = new LinkedHashMap<>();

        String line;
        while (!"end".equals(line = scanner.nextLine())) {
            String ip = line.substring(3, 15);
            String user = line.substring(43);

            usersData.putIfAbsent(user, new LinkedHashMap<>());

            Map<String, Integer> innerMap = usersData.get(user);
            innerMap.putIfAbsent(ip, 0);
            innerMap.put(ip, innerMap.get(ip) + 1);
        }
    }
}
