package Workshop1;

public class Main {
    public static void main(String[] args) throws Exception {

        SmartArray smartArray = new SmartArray();

        smartArray.add(1);
        smartArray.add(2);
        smartArray.add(3);
        smartArray.add(4);
        smartArray.add(5);
        System.out.println(smartArray.get(4));
        System.out.println();
    }
}
