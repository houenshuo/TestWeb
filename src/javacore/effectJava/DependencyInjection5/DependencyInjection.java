package javacore.effectJava.DependencyInjection5;

import java.util.function.Supplier;

public class DependencyInjection {
    private final Resource resource;// 通过作为属性 和 参数 进行赋值 叫做依赖（属性）注入

    public DependencyInjection(Resource resource) {
        this.resource = resource;
    }
    public Resource create(Supplier<? extends Resource> supplier){//Supplier 函数式编程 一般是结合lama表达式使用 能够接收一个函数对象
        return supplier.get();
    }
}
