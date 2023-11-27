package ProgrammingFundamentals.ObjectsAndClasses.Exercise.P02_Articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputData = scanner.nextLine().split(", ");
        String title = inputData[0];
        String content = inputData[1];
        String author = inputData[2];

        Article article = new Article(title, content, author);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String[] commandArgs = scanner.nextLine().split(": ");
            String command = commandArgs[0];
            String newText = commandArgs[1];

            if (command.equals("Edit")) {
                article.edit(newText);
            } else if (command.equals("ChangeAuthor")) {
                article.changeAuthor(newText);
            } else if (command.equals("Rename")) {
                article.rename(newText);
            }
        }


        System.out.println(article);
    }
}

