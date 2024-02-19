package StreamsFilesDirectories.Exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MergeTwoFiles {

    public static void main(String[] args)  {

        String inputOne = "C:\\Users\\Ivan\\Desktop\\JAVA\\Softuni\\Java Advanced 2024\\JavaAdvanced January 2024\\src\\StreamsFilesDirectories\\Exercise\\Resources\\inputOne.txt";
        String inputTwo = "C:\\Users\\Ivan\\Desktop\\JAVA\\Softuni\\Java Advanced 2024\\JavaAdvanced January 2024\\src\\StreamsFilesDirectories\\Exercise\\Resources\\inputTwo.txt";

        try (BufferedReader bf1 = new BufferedReader(new FileReader(inputOne));
                BufferedReader bf2 = new BufferedReader(new FileReader(inputTwo))){

            String line = bf1.readLine();
            while (!(line == null)) {
                System.out.println(line);

                line = bf1.readLine();
            }

            line = bf2.readLine();
            while (!(line == null)) {
                System.out.println(line);

                line = bf2.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
