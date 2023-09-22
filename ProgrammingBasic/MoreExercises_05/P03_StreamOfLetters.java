package MoreExercises_05;

import java.util.Scanner;

public class P03_StreamOfLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String text = "";
        String finalText = "";
        int c = 0;
        int n = 0;
        int o = 0;
        char symbol = 'a';

        while (!input.equals("End")) {
            symbol = input.charAt(0);
            if ((symbol >= 'A' && symbol <= 'Z') || (symbol >= 'a' && symbol <= 'z')) {
                if (symbol == 'c' || symbol == 'n' || symbol == 'o') {

                    if (symbol == 'c' && c == 0) {
                        c++;
                    } else if (symbol == 'n' && n == 0) {
                        n++;
                    } else if (symbol == 'o' && o == 0) {
                        o++;
                    } else {
                        text += symbol;
                    }

                    if (o + c + n == 3) {
                        text += " ";
                        c--;
                        n--;
                        o--;
                        finalText += text;
                        text = "";
                    }
                } else {
                    text += symbol;
                }

            }
            input = scanner.nextLine();
        }
        if (input.equals("End")) {
            System.out.println(finalText);

        }
    }
}
