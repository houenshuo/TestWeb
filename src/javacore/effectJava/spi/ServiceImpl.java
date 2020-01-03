package javacore.effectJava.spi;

/**
 * 服务者接口:具体的实现
 */
public class ServiceImpl implements IService{
    @Override
    public void sayHello() {
        System.out.println("say hello");
    }
}
