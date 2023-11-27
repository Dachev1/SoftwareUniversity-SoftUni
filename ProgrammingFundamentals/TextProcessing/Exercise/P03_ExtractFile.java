package ProgrammingFundamentals.TextProcessing.Exercise;

import java.util.Scanner;

public class P03_ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\\\");

        String fullInformation = input[input.length - 1];
        String fileName = fullInformation.split("\\.")[0];
        String extension = fullInformation.split("\\.")[1];

        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + extension);
    }
}
