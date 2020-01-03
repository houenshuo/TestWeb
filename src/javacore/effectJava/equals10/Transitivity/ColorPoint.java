package javacore.effectJava.equals10.Transitivity;

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
        // 必须使用instanceof操作符，检查参数类型是否正确，如果给的错误的类型将会抛出ClassCastException异常 同时可以检查obj是否null
    if (!(obj instanceof Point)){
        return false;
    }
    if (!(obj instanceof ColorPoint)){
        return obj.equals(this);
    }
    return super.equals(obj) && ((ColorPoint)obj).color == color;
}
}
