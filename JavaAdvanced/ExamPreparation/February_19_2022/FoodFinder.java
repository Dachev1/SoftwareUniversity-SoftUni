package ExamPreparation.February_19_2022;

import java.util.*;
import java.util.stream.Collectors;

public class FoodFinder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> vowels = new ArrayDeque<>(); // queue
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(vowels::offer);

        Deque<String> consonants = new ArrayDeque<>(); // stack
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(consonants::push);

        List<String> words = new ArrayList<>(List.of("pear", "flour", "pork", "olive"));

        while (!consonants.isEmpty()) {
            String vowel = vowels.poll();
            String consonant = consonants.pop();

            for (int i = 0; i < words.size(); i++) {
                String word = words.get(i);

                String updateWord = word;
                if (words.get(i).contains(vowel)) {
                    updateWord = word.replaceAll(vowel, "");
                }

                if (words.get(i).contains(consonant)) {
                    updateWord = updateWord.replaceAll(consonant, "");
                }

                words.set(i, updateWord);
            }
            vowels.offer(vowel);
        }

        int count = 0;
        List<String> foundWords = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).equals("")) {
                count++;
                if (i == 0) {
                    foundWords.add("pear");
                } else if (i == 1) {
                    foundWords.add("flour");
                } else if (i == 2) {
                    foundWords.add("pork");
                } else if (i == 3) {
                    foundWords.add("olive");
                }
            }
        }

        System.out.println("Words found: " + count);
        foundWords.forEach(System.out::println);
    }
    private static void fillConsonants(Scanner scanner, Deque<Character> consonants) {
        List<String> consonantsCollection = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        for (String chr : consonantsCollection) {
            consonants.push(chr.charAt(0));
        }
    }
}
