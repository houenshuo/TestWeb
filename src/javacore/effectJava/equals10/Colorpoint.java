package javacore.effectJava.equals10;

import javacore.effectJava.equals10.Transitivity.ColorPoint;
import javacore.effectJava.equals10.Transitivity.Point;

import java.awt.*;
import java.util.Objects;

public class Colorpoint {
    private final Point point;
    private Color color;

    public Colorpoint(int x,int y,Color color) {
        point =new Point(x,y);
        this.color = Objects.requireNonNull(color) ;
    }
    public Point asPoint(){
        return point;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Colorpoint))
            return false;
        // 在本类中可以使用private属性
        Colorpoint colorPoint =(Colorpoint)obj;
        return colorPoint.point.equals(point) && colorPoint.color.equals(color);
    }
}
