package StreamsFilesDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Set;

public class WriteToFile {

    public static void main(String[] args) {

        String inPath = "C:\\Users\\Ivan\\Desktop\\JAVA\\Softuni\\Java Advanced 2024\\JavaAdvanced January 2024\\src\\StreamsFilesDirectories\\input.txt";

        Set<Character> punctuation = Set.of(',', '.', '!', '?');

        try (FileInputStream fileInputStream = new FileInputStream(inPath);
             FileOutputStream fileOutputStream = new FileOutputStream("WriteToFile.txt")) {
            int oneByte = fileInputStream.read();
            while (oneByte >= 0) {
                if (!punctuation.contains((char)oneByte)) {
                    fileOutputStream.write(oneByte);
                }

                oneByte = fileInputStream.read();
            }
        } catch (Exception e) {

        }
    }
}
