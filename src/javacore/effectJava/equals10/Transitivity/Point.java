package javacore.effectJava.equals10.Transitivity;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
//        if (!(obj instanceof Point))
//            return false;
        // 只能同一个类的对象比较 拒绝继承等
        if (obj == null || obj.getClass()!=getClass())
            return false;
        Point p =(Point)obj;
        return p.x ==x && p.y==y;
    }
}
