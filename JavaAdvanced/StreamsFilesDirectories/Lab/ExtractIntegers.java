package StreamsFilesDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ExtractIntegers {

    public static void main(String[] args) {

        String path = "C:\\Users\\Ivan\\Desktop\\JAVA\\Softuni\\Java Advanced 2024\\JavaAdvanced January 2024\\src\\StreamsFilesDirectories\\input.txt";

        try (FileInputStream fileInputStream = new FileInputStream(path);
        Scanner scanner = new Scanner(fileInputStream)) {

            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    System.out.println(scanner.nextInt());
                }
                scanner.next();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
