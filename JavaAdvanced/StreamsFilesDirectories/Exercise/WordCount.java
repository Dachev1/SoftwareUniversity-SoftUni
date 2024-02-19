package StreamsFilesDirectories.Exercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordCount {

    public static void main(String[] args) {

        String wordsPath = "C:\\Users\\Ivan\\Desktop\\JAVA\\Softuni\\Java Advanced 2024\\JavaAdvanced January 2024\\src\\StreamsFilesDirectories\\Exercise\\Resources\\words.txt";

        Map<String, Integer> words = new HashMap<>();

        try (BufferedReader bf = new BufferedReader(new FileReader(wordsPath))){
            String line = bf.readLine();

            while (!(line == null)) {
                for (String word : line.split("\\s+")) {
                    words.put(word, 0);
                }

                line = bf.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String textPath = "C:\\Users\\Ivan\\Desktop\\JAVA\\Softuni\\Java Advanced 2024\\JavaAdvanced January 2024\\src\\StreamsFilesDirectories\\Exercise\\Resources\\text.txt";

        try (BufferedReader bf = new BufferedReader(new FileReader(textPath))){
            String line = bf.readLine();

            while (!(line == null)) {
                for (String word : line.split("\\s+")) {
                    if (words.containsKey(word)) {
                        words.put(word, words.get(word) + 1);
                    }
                }

                line = bf.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        words.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach((entry) -> {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        });
    }
}
