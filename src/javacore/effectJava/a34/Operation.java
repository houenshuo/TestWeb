package javacore.effectJava.a34;

public enum  Operation {
    P("+"){// 相当一个类使用
        public double apply(double x,double y){
            return  x+y;
        }
    };

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }
    public abstract double apply(double x,double y);
}
