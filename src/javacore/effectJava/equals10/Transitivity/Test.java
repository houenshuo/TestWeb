package javacore.effectJava.equals10.Transitivity;

import javacore.effectJava.equals10.Colorpoint;

import java.awt.*;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Point p =new Point(1,2);// 无色普通点
        ColorPoint colorPoint =new ColorPoint(1,2, Color.RED);// 有色点
        // 对称性
        System.out.println(p.equals(colorPoint));
        System.out.println(colorPoint.equals(p));
        Point p1 =new Point(1,2);// 无色普通点
        ColorPoint p2 =new ColorPoint(1,2, Color.RED);// 有色点
        ColorPoint p3 =new ColorPoint(1,2, Color.BLACK);// 有色点
        System.out.println(p2.equals(p1));
        System.out.println(p1.equals(p3));
        System.out.println(p2.equals(p3));

        Set<Point> set =Set.of(new Point(1,0),new Point(0,1),new Point(-1,0),new Point(0,-1));
        Counterpoint counterpoint =new Counterpoint(1,0);
        set.contains(counterpoint);//如果是getClass 无论Counterpoint怎么设置都是false，但是如果是instance 则是可以的
        // 如果是同类对象getClass运行很好，如果非同类对象建议使用instance但是要避免传递性


    }
    static boolean onUnitCircle(Set set,Point p){
        return set.contains(p);// 是否包含在单位圆中
    }
}
