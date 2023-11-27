package ProgrammingFundamentals.Lists.Exercise.MoreExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder hiddenMessage;
        hiddenMessage = new StringBuilder(scanner.nextLine());

        List<Character> characterList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();

        for (int i = 0; i < hiddenMessage.length(); i++) {
            char currentChar = hiddenMessage.charAt(i);
            if (Character.isDigit(currentChar)) {
                int characterValue = Character.getNumericValue(currentChar);
                integerList.add(characterValue);
            } else {
                characterList.add(currentChar);
            }
        }
        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();

        for (int i = 0; i < integerList.size(); i++) {
            if (i % 2 == 0) {
                takeList.add(integerList.get(i));
            } else {
                skipList.add(integerList.get(i));
            }
        }

        StringBuilder nonNumberedMessage = new StringBuilder();

        for (int i = 0; i < hiddenMessage.length(); i++) {
            char isLetterOrNot = hiddenMessage.charAt(i);
            if (!Character.isDigit(isLetterOrNot)) {
                nonNumberedMessage.append(isLetterOrNot);
            }

        }

        while (takeList.size() > 0 && skipList.size() > 0) {

            String encryptedMessage = "";

            while (nonNumberedMessage.length() > 0) {

                for (int i = 0; i < takeList.get(0); i++) {
                    if (nonNumberedMessage.length() == 0) {
                        break;
                    } else {
                        encryptedMessage += nonNumberedMessage.charAt(0);
                        nonNumberedMessage.deleteCharAt(0);
                    }
                }
                for (int i = 0; i < skipList.get(0); i++) {
                    if (nonNumberedMessage.length() == 0) {
                        break;
                    } else {
                        nonNumberedMessage.deleteCharAt(0);
                    }

                }
                takeList.remove(0);
                skipList.remove(0);
                if (takeList.size() == 0 && skipList.size() == 0) {
                    break;
                }
            }

            System.out.print(encryptedMessage);

        }
    }
}