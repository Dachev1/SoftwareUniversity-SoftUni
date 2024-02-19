package StreamsFilesDirectories;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortLines {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String path = "C:\\Users\\Ivan\\Desktop\\JAVA\\Softuni\\Java Advanced 2024\\JavaAdvanced January 2024\\src\\StreamsFilesDirectories\\input.txt";

            List<String> lines = Files.readAllLines(Paths.get(path));
        Collections.sort(lines);
        lines.forEach(System.out::println);

    }
}
