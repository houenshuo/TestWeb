package javacore.function;

import java.util.function.Supplier;

public class SupplierTest {
    public static void main(String[] args) {
        Supplier<String> supplier =()-> new String("say hello");//常用于业务“有条件运行”时，符合条件再调用获取结果的应用场景；运行结果须提前定义，但不运行（懒加载）。
        System.out.println(supplier.get());
    }
}
