package dataCollect;

import java.util.ArrayList;

public class text {
    private static ArrayList<A> as =new ArrayList<>();
    public static void main(String[] args) {
        A a =new A();
        for (int i=0;i<100;i++){
            for (int j=0;j<i;j++){
                a.setName("i"+i);
                put(a);
            }
        }
        for (A a1:as){
            System.out.println(a1.getName());
        }
    }
    public static void put(A a){
        as.add(a);
    }
}
