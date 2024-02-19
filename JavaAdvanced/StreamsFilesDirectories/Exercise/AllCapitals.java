package StreamsFilesDirectories.Exercise;

import java.io.*;

public class AllCapitals {

    public static void main(String[] args) {
        String inputDataPath = "C:\\Users\\Ivan\\Desktop\\JAVA\\Softuni\\Java Advanced 2024\\JavaAdvanced January 2024\\src\\StreamsFilesDirectories\\Exercise\\Resources\\input.txt";
        String outputDataPath = "C:\\Users\\Ivan\\Desktop\\JAVA\\Softuni\\Java Advanced 2024\\JavaAdvanced January 2024\\src\\StreamsFilesDirectories\\Exercise\\Resources\\output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputDataPath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputDataPath))) {

            String line = reader.readLine();

            while (!(line == null)) {
                writer.write(line.toUpperCase());
                writer.newLine();

                line = reader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
