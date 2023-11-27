package ProgrammingFundamentals.Methods.Lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P08_MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number = Double.parseDouble(scanner.nextLine());;
        int pow = Integer.parseInt(scanner.nextLine());


        DecimalFormat df = new DecimalFormat("0.####");
        System.out.println(df.format(Math.pow(number, pow)));
    }
}
