package StreamsFilesDirectories;

import java.io.BufferedReader;
import java.io.FileReader;

public class WriteEveryThirdLine {

    public static void main(String[] args) {

        String path = "C:\\Users\\Ivan\\Desktop\\JAVA\\Softuni\\Java Advanced 2024\\JavaAdvanced January 2024\\src\\StreamsFilesDirectories\\input.txt";

        try (FileReader fileReader = new FileReader(path);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            int count = 1;
            while (bufferedReader.ready()) {
                if (count == 3) {
                    System.out.println(bufferedReader.readLine());
                    count = 1;
                }

                count++;
                bufferedReader.readLine();
            }

        } catch (Exception e) {
        }
    }
}
