package javacore.effectJava.ServiceLoader;

public class Tom implements IMyServiceLoader {
    @Override
    public void getName() {
        System.out.println("Tom");
    }
}
