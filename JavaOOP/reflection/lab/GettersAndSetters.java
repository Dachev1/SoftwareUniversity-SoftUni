package reflection.lab;

import java.lang.reflect.Method;
import java.util.*;

public class GettersAndSetters {

    public static void main(String[] args) {

        Class<Reflection> reflection = Reflection.class;

        List<Method> getters = new ArrayList<>();
        List<Method> setters = new ArrayList<>();

        Method[] methods = reflection.getDeclaredMethods();

        for (Method method : methods) {
            boolean isStartWithGet = method.getName().startsWith("get");
            boolean isStartWithSet = method.getName().startsWith("set");
            boolean isVoid = method.getReturnType().getName().equals("void");
            boolean hasZeroParameters = method.getParameters().length == 0;
            boolean hasOneParameters = method.getParameters().length == 1;

            if (isStartWithGet && !isVoid && hasZeroParameters) {
                getters.add(method);
            } else if (isStartWithSet && isVoid && hasOneParameters) {
                setters.add(method);
            }
        }

        getters.sort(Comparator.comparing(Method::getName));
        setters.sort(Comparator.comparing(Method::getName));

        for (Method getter : getters) {
            System.out.printf("%s will return %s\n", getter.getName(), getter.getReturnType());
        }

        for (Method setter : setters) {
            System.out.printf("%s and will set field of class %s\n", setter.getName(), setter.getReturnType());
        }
    }
}
