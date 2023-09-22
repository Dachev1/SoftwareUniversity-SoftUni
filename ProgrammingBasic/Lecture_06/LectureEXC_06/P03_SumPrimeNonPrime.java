package Lecture_06.LectureEXC_06;

import java.util.Scanner;

public class P03_SumPrimeNonPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();

        int sumPrimeNumbers = 0;
        int sumNonPrimeNumbers = 0;

        //while -> докато не получим команда стоп

        while (!input.equals("stop")){

            //парсваме input към инт число
            int currentNumber = Integer.parseInt(input);

            boolean isPrime = true;

            // проверяваме дали числото е негативно
            if(currentNumber < 0){
                System.out.println("Number is negative.");
                input = scanner.nextLine();
                continue;
            }

            //правим for цикъл от 2 до прочетеното число
            for (int i = 2; i < currentNumber ; i++) {

                // правим проверка дали можем да разделим целочислено currentNumber с i
                if(currentNumber % i == 0){
                    sumNonPrimeNumbers += currentNumber;
                    isPrime = false;
                    break;
                }

            }

            //проверяваме дали isPrime = true
            if (isPrime){
                sumPrimeNumbers += currentNumber;
            }


            input = scanner.nextLine();
        }

        System.out.printf("Sum of all prime numbers is: %d%n", sumPrimeNumbers);
        System.out.printf("Sum of all non prime numbers is: %d%n", sumNonPrimeNumbers);
    }
}