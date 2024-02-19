package DefiningClasses.Exercise.CatLady;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line;
        Map<String, Cat> cats = new HashMap<>();

        while (!"End".equals(line = scanner.nextLine())) {
            String[] lineArgs = line.split("\\s+");

            String type = lineArgs[0];
            String name = lineArgs[1];
            Cat cat;

            switch (type) {
                case "Siamese":
                    double earSize = Double.parseDouble(lineArgs[2]);
                    cat = new Siamese(type, name, earSize);
                    break;
                case "Cymric":
                    double furLength = Double.parseDouble(lineArgs[2]);
                    cat = new Cymric(type, name, furLength);
                    break;
                default:
                    double decibelsOfMeows = Double.parseDouble(lineArgs[2]);
                    cat = new StreetExtraordinaire(type, name, decibelsOfMeows);
                    break;
            }

            cats.put(name, cat);
        }

        System.out.println(cats.get(scanner.nextLine()));
    }
}
