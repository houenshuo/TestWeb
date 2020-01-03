package javacore.effectJava.a33;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Favorites {
    private Map<Class<?>,Object> favorites =new HashMap<>();

    public <T> void putFavorite(Class<T> type,T instance){
        favorites.put(Objects.requireNonNull(type),type.cast(instance));// type.cast是为了恶意的客户端破坏传入非type类型的值
    }
    public <T> T getFavorite(Class<T> type){
        //public T cast(Object obj)
        return type.cast(favorites.get(type));
        //return (T)favorites.get(type);
    }

    public static void main(String[] args) {
        Favorites f =new Favorites();
        f.putFavorite(String.class,"java");// String.class称为类型令牌 属于class<String>
        f.putFavorite(Integer.class,0xcafebabe);
        f.putFavorite(Class.class,Favorites.class);
        String favoriteInteger =f.getFavorite(String.class);
        System.out.println(favoriteInteger);
    }
}
