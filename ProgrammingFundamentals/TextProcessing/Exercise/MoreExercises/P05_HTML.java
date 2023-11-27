package ProgrammingFundamentals.TextProcessing.Exercise.MoreExercises;

import java.util.Scanner;

public class P05_HTML {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // title of an article.
        String titleArticle = scanner.nextLine();
        System.out.printf("<h1>\n    %s\n</h1>\n", titleArticle);

        // content of that article
        String contentArticle = scanner.nextLine();
        System.out.printf("<article>\n    %s\n</article>\n", contentArticle);

        // comments of article
        while (true) {
            String commentsOfArticle = scanner.nextLine();

            if (commentsOfArticle.equals("end of comments")) {
                break;
            }

            System.out.printf("<div>\n    %s\n</div>\n", commentsOfArticle);
        }
    }
}
