package polymorphism.lab.math_operation;

public class Main {

    public static void main(String[] args) {

        MathOperation mathOperation = new MathOperation();
        System.out.println(mathOperation.add(1, 1));
        System.out.println(mathOperation.add(1, 1, 1));
        System.out.println(mathOperation.add(1, 1, 1, 1));
    }
}
