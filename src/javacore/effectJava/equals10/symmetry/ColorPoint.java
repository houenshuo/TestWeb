package javacore.effectJava.equals10.symmetry;

import java.awt.*;

public class ColorPoint extends Point {
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

//    @Override
//    public boolean equals(Object obj) {
//        // 添加上颜色的比较，如果直接继承父类的话 就无法进行颜色的比较
//        // 但是会出现对称性问题
//        if (!(obj instanceof ColorPoint)){
//            return false;
//        }
//        return super.equals(obj) && ((ColorPoint)obj).color == color;
//    }
@Override
public boolean equals(Object obj) {
//    if (!(obj instanceof Point)){
//        return false;
//    }
    // 带来的问题：（1）传递性（2）自身性（无限递归）
    // 所以：我们无法在扩展可实例化类的同时，即增加新的值组件，同时有保留equals约定。
    // 问题的根本 就是在与非同一个类的进行比较 Point只比较x y 但是子类还要比较颜色 可以在Point中用getClass代替instanceof 取消继承的情况 只要求同一个类的对象
    if (!(obj instanceof ColorPoint)){
        return obj.equals(this);
    }
    return super.equals(obj) && ((ColorPoint)obj).color == color;
}
}
