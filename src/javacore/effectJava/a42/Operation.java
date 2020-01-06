package javacore.effectJava.a42;

import java.util.function.DoubleBinaryOperator;

public enum  Operation {
    P("+",(x,y)->x+y);
    private final String symbol;
    private final DoubleBinaryOperator op;

    Operation(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }
    public double apply(double x,double y){
        return op.applyAsDouble(x,y);
    }

    public static void main(String[] args) {
        System.out.printf(""+Operation.P.apply(1,2));
    }

}
