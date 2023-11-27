package ProgrammingFundamentals.FinalExamPractise;

import java.util.*;

public class P03_ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, List<String>> collection  = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] data = input.split("\\|");
            String piece = data[0];
            String composer = data[1];
            String key = data[2];

            collection.putIfAbsent(piece, new ArrayList<>());
            collection.get(piece).add(composer);
            collection.get(piece).add(key);
        }



        while (true) {
            String input = scanner.nextLine();

            if (input.equals("Stop")) {
                break;
            }

            String[] data = input.split("\\|");
            String command = data[0];

            if (command.equals("Add")) {
                String piece = data[1];
                String composer = data[2];
                String key = data[3];

                if (collection.containsKey(piece)) {
                    System.out.printf("%s is already in the collection!\n", piece);
                } else {
                    collection.putIfAbsent(piece, new ArrayList<>());
                    collection.get(piece).add(composer);
                    collection.get(piece).add(key);
                    System.out.printf("%s by %s in %s added to the collection!\n", piece, composer ,key);
                }
            } else if (command.equals("Remove")) {
                String piece = data[1];

                if (collection.containsKey(piece)) {
                    collection.remove(piece);
                    System.out.printf("Successfully removed %s!\n",piece);
                } else {
                    System.out.printf("Invalid operation! %s does not exist in the collection.\n", piece);
                }
            } else if (command.equals("ChangeKey")) {
                String piece = data[1];
                String newKey = data[2];

                if (collection.containsKey(piece)){
                    collection.get(piece).set(1,newKey);
                    System.out.printf("Changed the key of %s to %s!%n",piece,newKey);
                }else {
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n",piece);
                }
            }
        }

        collection.entrySet().stream()
                .forEach(kvp -> System.out.printf("%s -> Composer: %s, Key: %s%n",
                        kvp.getKey(), kvp.getValue().get(0), kvp.getValue().get(1)));
    }
}
