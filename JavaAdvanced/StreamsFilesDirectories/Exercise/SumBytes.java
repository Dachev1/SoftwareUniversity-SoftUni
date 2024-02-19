package StreamsFilesDirectories.Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes {

    public static void main(String[] args) {
        String inputDataPath = "C:\\Users\\Ivan\\Desktop\\JAVA\\Softuni\\Java Advanced 2024\\JavaAdvanced January 2024\\src\\StreamsFilesDirectories\\Exercise\\Resources\\input.txt";

        try (BufferedReader bf = new BufferedReader(new FileReader(inputDataPath))) {
            String line = bf.readLine();

            int sum = 0;
            while (!(line == null)) {
                for (char ch : line.toCharArray()) {
                    sum += ch;
                }

                line = bf.readLine();
            }

            System.out.println(sum);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
