package reflection.lab;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class PrintClassInformation {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<Reflection> reflection = Reflection.class;
        System.out.println(reflection);

        Class<? super Reflection> supperClass = reflection.getSuperclass();
        System.out.println(supperClass);

        Class<?>[] interfaces = reflection.getInterfaces();
        Arrays.stream(interfaces).forEach(System.out::println);

        Reflection reflectionObject = reflection.getDeclaredConstructor().newInstance();
        System.out.println(reflectionObject);

    }
}
