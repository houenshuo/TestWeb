package javacore.effectJava.Builder2;

public class test {
    public static void main(String[] args) {
       graph graph =new graph.Builder(100,100).isZoom(false).name("正方形").build();
        System.out.println(graph.toString());

        Pizza myPizza = new MyPizza.MyBuilder(MyPizza.Size.SMALL).addTopping(Pizza.Topping.HAM).addTopping(Pizza.Topping.IHOI).build();


    }
}
