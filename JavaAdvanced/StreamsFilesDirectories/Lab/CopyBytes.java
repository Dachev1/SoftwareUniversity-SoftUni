package StreamsFilesDirectories;

import java.io.FileInputStream;

public class CopyBytes {

    public static void main(String[] args) {
        
        String path = "C:\\Users\\Ivan\\Desktop\\JAVA\\Softuni\\Java Advanced 2024\\JavaAdvanced January 2024\\src\\StreamsFilesDirectories\\input.txt";
        
        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            int oneByte = fileInputStream.read();
            while (oneByte >= 0) {
                String digit = String.valueOf(oneByte);
                    if (digit.equals("32")) {
                        System.out.print(" ");
                    } else if (digit.equals("10")) {
                        System.out.println();
                    } else {
                        System.out.print(digit);
                    }

                oneByte = fileInputStream.read();
            }
        } catch (Exception e) {}
    }
}
