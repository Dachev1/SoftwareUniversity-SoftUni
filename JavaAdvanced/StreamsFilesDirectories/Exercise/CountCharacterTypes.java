package StreamsFilesDirectories.Exercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

public class CountCharacterTypes {

    public static void main(String[] args) {

        String inputPathData = "C:\\Users\\Ivan\\Desktop\\JAVA\\Softuni\\Java Advanced 2024\\JavaAdvanced January 2024\\src\\StreamsFilesDirectories\\Exercise\\Resources\\input.txt";

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        Set<Character> punctuation = Set.of('!', ',', '.', '?');

        int vowelsCount = 0;
        int punctuationCount = 0;
        int otherSymbolsCount = 0;

        try (BufferedReader bf = new BufferedReader(new FileReader(inputPathData))) {

            String line = bf.readLine();

            while (!(line == null)) {

                for (char ch : line.toCharArray()) {
                    if (vowels.contains(ch)) {
                        vowelsCount++;
                    } else if (punctuation.contains(ch)) {
                        punctuationCount++;
                    } else if (ch != ' ') {
                        otherSymbolsCount++;
                    }
                }

                line = bf.readLine();
            }

            System.out.println("Vowels: " + vowelsCount);
            System.out.println("Other symbols: " + otherSymbolsCount);
            System.out.println("Punctuation: " + punctuationCount);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
