package javacore.effectJava.Builder2;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public class Pizza {
    public enum Topping{HAM,MUSHROOM,ONIUHUH,IHOI,IYHOI};// pizza的配料种类
    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>>{// T只能是Builder的子类
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);//初始化
        public T addTopping(Topping topping){
            toppings.add(Objects.requireNonNull(topping));
            return self();// 返回T（子类）对象
        }
        abstract Pizza build();// 返回子类的实现 -----称作 协变返回类型 允许客户端无须转换类型就能使用这些客户端

        protected abstract T self();//返回T对象
    }
    Pizza(Builder<?> builder){
        toppings =builder.toppings.clone();//初始化
    }
}
