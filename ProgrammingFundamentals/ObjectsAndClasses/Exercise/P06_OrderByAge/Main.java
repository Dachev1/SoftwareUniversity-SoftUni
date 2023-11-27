package ProgrammingFundamentals.ObjectsAndClasses.Exercise.P06_OrderByAge;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<PersonInfo> personInfos = new ArrayList<>();

      while (true) {
          String input = scanner.nextLine();

          if (input.equals("End")) {
              break;
          }

          String name = input.split(" ")[0];
          String id = input.split(" ")[1];
          int age = Integer.parseInt(input.split(" ")[2]);

          PersonInfo personInfo = new PersonInfo(name, id, age);
          personInfos.add(personInfo);
      }

        Collections.sort(personInfos, Comparator.comparingDouble(PersonInfo::getAge));

      for (PersonInfo personInfo : personInfos) {
          System.out.println(personInfo);
      }

    }
}
