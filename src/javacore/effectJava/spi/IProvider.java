package javacore.effectJava.spi;

/**
 * 服务提供者接口（非重要组件）：产生服务接口实例的工厂对象，可以没有这个接口，实现就通过反射进行实例化
 * (单一职责：实现将服务实现注册到容器中)
 */
public interface IProvider {
    IService getIservice();
}
