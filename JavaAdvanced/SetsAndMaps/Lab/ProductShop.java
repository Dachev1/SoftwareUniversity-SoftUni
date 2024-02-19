import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> shopData = new TreeMap<>();

        String line;

        while (!"Revision".equals(line = scanner.nextLine())) {
            String[] tokens = line.split(",\\s+");
            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            shopData.putIfAbsent(shop, new LinkedHashMap<>());
            Map<String, Double> innerMap = shopData.get(shop);
            innerMap.put(product, price);
        }

        shopData.forEach((shop, data) -> {
            System.out.printf("%s->\n", shop);
            data.forEach((product, price) -> {
                System.out.printf("Product: %s, Price: %.1f\n", product, price);
            });
        });
    }
}
