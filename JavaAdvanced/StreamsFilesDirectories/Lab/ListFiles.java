package StreamsFilesDirectories;

import java.io.File;

public class ListFiles {

    public static void main(String[] args) {

        File file = new File("C:\\Users\\Ivan\\Desktop\\JAVA\\Softuni\\Java Advanced 2024\\JavaAdvanced January 2024\\src\\StreamsFilesDirectories\\Files-and-Streams");

        if (file.exists()) {
            File[] files = file.listFiles();

            for (File f : files) {
                if (!f.isDirectory()) {
                    System.out.printf("%s: [%d]\n", f.getName(), f.length());
                }
            }
        }
    }
}
