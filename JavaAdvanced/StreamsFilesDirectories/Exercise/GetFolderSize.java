package StreamsFilesDirectories.Exercise;

import java.io.File;
import java.util.List;

public class GetFolderSize {

    public static void main(String[] args) {

        String path = "C:\\Users\\Ivan\\Desktop\\JAVA\\Softuni\\Java Advanced 2024\\JavaAdvanced January 2024\\src\\StreamsFilesDirectories\\Exercise\\Resources\\Exercises Resources";

        File dir = new File(path);


        System.out.println("Folder size: " + getDirectorySize(dir));
    }

    public static long getDirectorySize(File dir) {
        long length = 0;
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile())
                    length += file.length();
                else
                    length += getDirectorySize(file);
            }
        }
        return length;

    }
}
