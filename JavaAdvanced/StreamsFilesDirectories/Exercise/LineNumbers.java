package StreamsFilesDirectories.Exercise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LineNumbers {

    public static void main(String[] args) {

        String inputDataPath = "C:\\Users\\Ivan\\Desktop\\JAVA\\Softuni\\Java Advanced 2024\\JavaAdvanced January 2024\\src\\StreamsFilesDirectories\\Exercise\\Resources\\inputLineNumbers.txt";

        try (BufferedReader bf = new BufferedReader(new FileReader(inputDataPath))){
            String line = bf.readLine();

            int count = 1;
            while (!(line == null)) {
                System.out.printf("%d. %s\n", count++, line);

                line = bf.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
