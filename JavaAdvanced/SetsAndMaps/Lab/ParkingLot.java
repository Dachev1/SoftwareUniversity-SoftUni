import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> parking = new LinkedHashSet<>();

        String line;
        while (!"END".equals(line = scanner.nextLine())) {
            String[] tokens = line.split(",\\s+");

            if ("IN".equals(tokens[0])) {
                parking.add(tokens[1]);
            } else if ("OUT".equals(tokens[0])) {
                parking.remove(tokens[1]);
            }
        }

        if (parking.isEmpty()) {
            System.out.println("ExamPreparation.June_28_2020.Parking Lot is Empty");
        } else {
            parking.forEach(System.out::println);
        }
    }
}
