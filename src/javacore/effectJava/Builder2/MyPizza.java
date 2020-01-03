package javacore.effectJava.Builder2;

import java.util.Objects;

public class MyPizza extends Pizza {
    public enum Size{SMALL,MEDIUM,LARGE}
    private final Size size;
    public static class MyBuilder extends Pizza.Builder<MyBuilder>{
        private final Size size;
        public MyBuilder(Size size){
            this.size = Objects.requireNonNull(size);
        }

        @Override
        Pizza build() {
            return new MyPizza(this);
        }

        @Override
        protected MyBuilder self() {
            return this;
        }
    }

    public MyPizza(MyBuilder builder) {
        super(builder);
        this.size = builder.size;
    }
}
