package EXAM;

import java.util.Scanner;

public class P01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double processor = Double.parseDouble(scanner.nextLine());
        double videoCard = Double.parseDouble(scanner.nextLine());
        double ram = Double.parseDouble(scanner.nextLine());
        int ramCount = Integer.parseInt(scanner.nextLine());
        double percentDiscount = Double.parseDouble(scanner.nextLine());

        double processorPriceBg = processor * 1.57;
        double videoCardPriceBg = videoCard * 1.57;
        double ramPriceBg = (ram * 1.57) * ramCount;

        double processorWithDiscount = processorPriceBg - (processorPriceBg * percentDiscount);
        double videoCardWithDiscount = videoCardPriceBg - (videoCardPriceBg * percentDiscount);

        double totalPrice = processorWithDiscount + videoCardWithDiscount + ramPriceBg;

        System.out.printf("Money needed - %.2f leva.", totalPrice);

    }
}
