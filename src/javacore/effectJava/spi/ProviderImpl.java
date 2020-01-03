package javacore.effectJava.spi;


public class ProviderImpl implements IProvider {
    /**	 * 实现静态的注册	 */
    private static final String DEFAULT_PROVIDER = "test";
    static {
        ServiceManager.registerProvider(DEFAULT_PROVIDER, new ProviderImpl());
    }
    @Override
    public IService getIservice() {
        return new ServiceImpl();
    }
}
