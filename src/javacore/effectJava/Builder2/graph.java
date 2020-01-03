package javacore.effectJava.Builder2;

public class graph{
    private final int width;
    private final int hight;
    private final String name;
    private final int num;
    private final boolean zoom;

    @Override
    public String toString() {
        return "graph{" +
                "width=" + width +
                ", hight=" + hight +
                ", name='" + name + '\'' +
                ", num=" + num +
                ", zoom=" + zoom +
                '}';
    }

    public static class Builder{
        private final int width;
        private final int hight;
        private  String name;
        private  int num;
        private  boolean zoom;

        public Builder(int width, int hight) {
            this.width = width;
            this.hight = hight;
        }

        public Builder name(String val) {
            name =val;
            return this;
        }

        public Builder num(int val) {
            num =val;
            return this;
        }

        public Builder isZoom(boolean val) {
            zoom =val;
            return this;
        }
        public graph build(){
            return new graph(this);
        }
    }
    public graph(Builder builder) {
        this.width = builder.width;
        this.hight = builder.hight;
        this.name = builder.name;
        this.num = builder.num;
        this.zoom = builder.zoom;
    }
}
