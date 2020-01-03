package javacore.effectJava.ServiceLoader;

import java.util.ServiceLoader;

public class TestMyServiceLoader {
    public static void main(String[] args) {
        ServiceLoader<IMyServiceLoader> serviceLoaders =ServiceLoader.load(IMyServiceLoader.class);
        for (IMyServiceLoader iMyServiceLoader:serviceLoaders){
            iMyServiceLoader.getName();
        }
    }
}
