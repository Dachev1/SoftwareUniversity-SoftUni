package StreamsFilesDirectories;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Stack;

public class NestedFolders {

    public static void main(String[] args) {

        String mainDir = "C:\\Users\\Ivan\\Desktop\\JAVA\\Softuni\\Java Advanced 2024\\JavaAdvanced January 2024\\src\\StreamsFilesDirectories\\Files-and-Streams";
        // File object
        File file = new File(mainDir);
        ArrayDeque<File> s = new ArrayDeque<>();
        s.offer(file);

        int countOfDir = 0;
        while (!s.isEmpty()) {
            File tmpF = s.poll();

            if (tmpF.isDirectory()) {
                File[] f = tmpF.listFiles();
                System.out.println(tmpF.getName());
                countOfDir++;

                for (File fpp : f) {
                    s.offer(fpp);
                }
            }
        }

        System.out.println(countOfDir + " folders");
    }
}