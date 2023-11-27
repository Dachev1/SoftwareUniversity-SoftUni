package ProgrammingFundamentals.ObjectsAndClasses;

import java.util.*;
import java.util.stream.Collectors;


public class P01_RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> text = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());
        
        Random rdm = new Random();

        int size = text.size();
        for (int i = 0; i < size; i++) {
            String randomWord = text.get(rdm.nextInt(text.size()));
            System.out.println(randomWord);
            text.remove(randomWord);
        }
    }
}
