package ProgrammingFundamentals.ObjectsAndClasses.P04_Songs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Song> songs = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String[] songArgs = scanner.nextLine().split("_");
            String typeList = songArgs[0];
            String name = songArgs[1];
            String time = songArgs[2];

            Song song = new Song(typeList, name, time);
            songs.add(song);
        }

        String filter = scanner.nextLine();
        boolean isAll = !filter.equals("all");

        for (Song song : songs) {
            if (!isAll) {
                System.out.println(song.getName());
            } else if (song.getListType().equals(filter)) {
                System.out.println(song.getName());
            }
        }
    }
}
