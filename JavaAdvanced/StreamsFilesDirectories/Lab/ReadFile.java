package StreamsFilesDirectories;
import java.io.FileInputStream;

public class ReadFile {

    public static void main(String[] args) {

        String path = "C:\\Users\\Ivan\\Desktop\\JAVA\\Softuni\\Java Advanced 2024\\JavaAdvanced January 2024\\src\\StreamsFilesDirectories\\input.txt";

        try (FileInputStream fileInputStream = new FileInputStream(path);) {
            int oneByte = fileInputStream.read();
            while (oneByte >= 0) {
                System.out.print(Integer.toBinaryString(oneByte) + " ");
                oneByte = fileInputStream.read();
            }
        } catch (Exception e) {

        }
    }
}
