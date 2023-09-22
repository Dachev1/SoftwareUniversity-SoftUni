package Lecture_03.LectureEXC_03;

import java.util.Scanner;

public class P08_OnTimeForTheExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int examHour = Integer.parseInt(scanner.nextLine());
        int examMinutes = Integer.parseInt(scanner.nextLine());
        int arrivalHour = Integer.parseInt(scanner.nextLine());
        int arrivalMinutes = Integer.parseInt(scanner.nextLine());

        //превръщаме всичко в минути
        int examTotalMinutes = examHour * 60 + examMinutes;
        int arrivalTotalMinutes = arrivalHour * 60 + arrivalMinutes;

        int diffMinutes = Math.abs(examTotalMinutes - arrivalTotalMinutes);

        //правим проверка дали е закъснял
        if(arrivalTotalMinutes > examTotalMinutes){
            System.out.println("Late");
            //Ако разликата в минутите на пристига и минутите на изпита е по-малка от 60 -> принтираме минути
            //Ако разликата е по-голяма трябва да принтираме час:минути

            if(diffMinutes < 60){
                System.out.printf("%d minutes after the start", diffMinutes);
            }else {

                int hour = diffMinutes / 60;
                int minute = diffMinutes % 60;
                System.out.printf("%d:%02d hours after the start", hour, minute);
            }

        }else  if( diffMinutes <= 30){
            System.out.println("On time");

            if (diffMinutes != 0){
                System.out.printf("%d minutes before the start", diffMinutes);
            }

        }else {
            System.out.println("Early");
            if (diffMinutes < 60){
                System.out.printf("%d minutes before the start", diffMinutes);
            }else {

                int hour = diffMinutes / 60;
                int minute = diffMinutes % 60;
                System.out.printf("%d:%02d hours before the start", hour, minute);


            }

        }


    }
}