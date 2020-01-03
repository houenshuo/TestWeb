package javacore.effectJava.spi;

public class client {
    public static void main(String[] args) throws ClassNotFoundException {
        /**
         * 1，使用静态工厂 避免 调用端new对象
         * 2，使用注册，可以更好的管理对象
         */
        Class.forName("javacore.effectJava.spi.ProviderImpl");// 将服务提供者的实现类注册（可以没有，可以自己进行注册）
        IService iService =ServiceManager.getIService("test");
        iService.sayHello();
    }
}
