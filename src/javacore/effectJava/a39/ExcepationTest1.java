package javacore.effectJava.a39;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(ExceptionTestContainer.class)
public @interface ExcepationTest1 {
    Class<? extends Exception> value();
}
