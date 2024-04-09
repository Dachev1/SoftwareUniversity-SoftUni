package working_with_abstraction.lab.PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rectangleCoordinates = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Point bottomPoints = new Point(rectangleCoordinates[0], rectangleCoordinates[1]);
        Point topPoints = new Point(rectangleCoordinates[2], rectangleCoordinates[3]);
        Rectangle rectangle = new Rectangle(bottomPoints, topPoints);

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            int[] coordinates = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            Point point = new Point(coordinates[0], coordinates[1]);

            System.out.println(rectangle.contains(point));
        }
    }
}
