package Inheritance.Exercise.Animals;

import Inheritance.Exercise.Animals.Cat.Cat;
import Inheritance.Exercise.Animals.Cat.Kitten;
import Inheritance.Exercise.Animals.Cat.Tomcat;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line;
        while (!"Beast!".equals(line = scanner.nextLine())) {
            String[] tokens = scanner.nextLine().split("\\s+");
            try {
                switch (line) {
                    case "Dog":
                        Dog dog = new Dog(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                        System.out.println(dog);
                        break;
                    case "Cat":
                        Cat cat = new Cat(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                        System.out.println(cat);
                        break;
                    case "Frog":
                        Frog frog = new Frog(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                        System.out.println(frog);
                        break;
                    case "Kittens":
                        Kitten kittens = new Kitten(tokens[0], Integer.parseInt(tokens[1]));
                        System.out.println(kittens);
                        break;
                    case "Tomcat":
                        Tomcat tomcat = new Tomcat(tokens[0], Integer.parseInt(tokens[1]));
                        System.out.println(tomcat);
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
