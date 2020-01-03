package javacore.effectJava.spi;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceManager {
    public static ConcurrentHashMap<String,IProvider> providers =new ConcurrentHashMap<>();// 注册容器
    public static ConcurrentHashMap<String,IService> services =new ConcurrentHashMap<>();// 注册容器
    /**
     *  服务提供者注册（重要组件）
     *     静态工厂方法
      */
    public static void registerProvider(String name,IProvider iProvider) {
        providers.put(name,iProvider);
    }
    public static void registerProvider(String name,String className) {
        try {
            Class clazz =Class.forName(className);
            services.put(name, (IService) clazz.getDeclaredConstructor().newInstance());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     *服务访问（重要组件）
     */
    public static IService getIService(String name){
        IProvider iProvider =providers.get(name);
        return iProvider.getIservice();// 返回真正的服务对象
    }
}
