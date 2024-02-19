package StreamsFilesDirectories.Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumLines {

    public static void main(String[] args) {
        String inputDataPath = "C:\\Users\\Ivan\\Desktop\\JAVA\\Softuni\\Java Advanced 2024\\JavaAdvanced January 2024\\src\\StreamsFilesDirectories\\Exercise\\Resources\\input.txt";

        try (BufferedReader bf = new BufferedReader(new FileReader(inputDataPath))) {
            String line = bf.readLine();

            while (!(line == null)) {
                int sum = 0;
                for (char ch : line.toCharArray()) {
                    sum += ch;
                }

                System.out.println(sum);
                line = bf.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
