package DefiningClasses.Exercise.Google;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line;
        Map<String, Person> people = new HashMap<>();
        while (!"End".equals(line = scanner.nextLine())) {
            String[] lineArgs = line.split("\\s+");

            String name = lineArgs[0];
            String command = lineArgs[1];

            people.putIfAbsent(name, new Person());

            switch (command) {
                case "company":
                    String companyName = lineArgs[2];
                    String department = lineArgs[3];
                    double salary = Double.parseDouble(lineArgs[4]);

                    Company company = new Company(companyName, department, salary);
                    people.get(name).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = lineArgs[2];
                    String pokemonType = lineArgs[3];

                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    people.get(name).getPokemonList().add(pokemon);
                    break;
                case "parents":
                    String parentName = lineArgs[2];
                    String parentBirthday = lineArgs[3];

                    Parent parent = new Parent(parentName, parentBirthday);
                    people.get(name).getParentList().add(parent);
                    break;
                case "children":
                    String childName = lineArgs[2];
                    String childBirthday = lineArgs[3];

                    Child child = new Child(childName, childBirthday);
                    people.get(name).getChildList().add(child);
                    break;
                case "car":
                    String carModel = lineArgs[2];
                    int carSpeed = Integer.parseInt(lineArgs[3]);

                    Car car = new Car(carModel, carSpeed);
                    people.get(name).setCar(car);
                    break;
            }
        }

        String searchedPerson = scanner.nextLine();
        System.out.println(searchedPerson);
        people.get(searchedPerson).printFormat();
    }
}
