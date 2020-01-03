package javacore.effectJava.equals10.symmetry;

import java.awt.*;

public class Test {
    public static void main(String[] args) {
        Point p =new Point(1,2);// 无色普通点
        ColorPoint colorPoint =new ColorPoint(1,2, Color.RED);// 有色点
        // 对称性
        System.out.println(p.equals(colorPoint));
        System.out.println(colorPoint.equals(p));
    }
}
