package javacore.effectJava.a39;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunTests {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        int tests =0;
        int passed =0;
        Class<?> testClass =Class.forName(args[0]);
        for (Method method:testClass.getDeclaredMethods()){
            if (method.isAnnotationPresent(Test.class)){
                tests++;
                method.invoke(null);
                passed++;
            }
        }

    }
}
