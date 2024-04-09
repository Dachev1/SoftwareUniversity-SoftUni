package reflection.lab;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HighQualityMistakes {

    public static void main(String[] args) {

        Class<Reflection> reflectionClass = Reflection.class;

        // GET FIELDS
        Field[] fields = reflectionClass.getDeclaredFields();
        List<Field> mistakenField = new ArrayList<>();
        for (Field field : fields) {
            int modifier = field.getModifiers();
            if (!(Modifier.isPrivate(modifier))) {
                mistakenField.add(field);
            }
        }

        // GET GETTERS & SETTERS
        Method[] methods = reflectionClass.getDeclaredMethods();
        List<Method> mistakenGetters = new ArrayList<>();
        List<Method> mistakenSetters = new ArrayList<>();
        for (Method method : methods) {
            int modifier = method.getModifiers();
            boolean isStartWithGet = method.getName().startsWith("get");
            boolean isStartWithSet = method.getName().startsWith("set");
            boolean isVoid = method.getReturnType().getName().equals("void");
            boolean hasZeroParameters = method.getParameters().length == 0;
            boolean hasOneParameters = method.getParameters().length == 1;

            if (isStartWithGet && !isVoid && hasZeroParameters) {
                if (!(Modifier.isPublic(modifier))) {
                    mistakenGetters.add(method);
                }
            } else if (isStartWithSet && isVoid && hasOneParameters) {
                if (!(Modifier.isPrivate(modifier))) {
                    mistakenSetters.add(method);
                }
            }
        }


        // PRINT
        mistakenField.sort(Comparator.comparing(Field::getName));
        mistakenGetters.sort(Comparator.comparing(Method::getName));
        mistakenSetters.sort(Comparator.comparing(Method::getName));

        for (Field field : mistakenField) {
            System.out.printf("%s must be private!\n", field.getName());
        }

        for (Method getter : mistakenGetters) {
            System.out.printf("%s have to be public!\n", getter.getName());
        }

        for (Method setter : mistakenSetters) {
            System.out.printf("%s have to be private!\n", setter.getName());
        }
    }
}
