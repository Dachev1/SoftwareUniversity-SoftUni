package reflection.exercise.black_box_integer;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();

        Scanner scanner = new Scanner(System.in);
        String line;
        while (!"END".equals(line = scanner.nextLine())) {
            String[] tokens = line.split("_");
            String commandName = tokens[0];
            int value = Integer.parseInt(tokens[1]);

            Method method = clazz.getDeclaredMethod(commandName, int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt, value);

            Field field = clazz.getDeclaredField("innerValue");
            field.setAccessible(true);

            System.out.println(field.get(blackBoxInt));
        }

    }
}
