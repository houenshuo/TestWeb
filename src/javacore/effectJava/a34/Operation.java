package javacore.effectJava.a34;

public enum  Operation {
    P("+"){// 相当一个对象使用
        public double apply(double x,double y){
            return  x+y;
        }
    };

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }
    public abstract double apply(double x,double y);

    public static void main(String[] args) {
        System.out.println(Operation.P.apply(1,2));
    }
}
