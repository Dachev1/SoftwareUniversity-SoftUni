package ProgrammingFundamentals.RegularFinalExam;

import java.util.*;

public class P03_Dictionary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, List<String>> notebook = new LinkedHashMap<>();

        String[] allWordsDefinitions = scanner.nextLine().split(" \\| ");

        for (String eachWordAndDefinitions : allWordsDefinitions) {
            String[] tokens = eachWordAndDefinitions.split(": ");
            String word = tokens[0];
            String definition = tokens[1];

            if (notebook.containsKey(word)) {
                notebook.get(word).add(definition);
            } else {
                notebook.put(word, new ArrayList<>());
                notebook.get(word).add(definition);
            }
        }

        String[] testWord = scanner.nextLine().split(" \\| ");
        String command = scanner.nextLine();

        if (command.equals("Test")) {
            for (String word : testWord) {
                if (notebook.containsKey(word)) {
                   for (String str : notebook.keySet()) {
                       if (str.equals(word)) {
                           System.out.printf("%s:\n", word);
                           notebook.get(word).forEach(v -> {
                               System.out.printf("-%s\n", v);
                           });
                       }
                   }
                }
            }
        } else if (command.equals("Hand Over")) {
            notebook.forEach((k, v) -> {
                System.out.printf("%s ", k);
            });
        }
    }
}
