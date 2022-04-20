package cn.chincloud.chinchain.contract.support.classloader;

import java.io.IOException;

public class SmartContractExecutorClassLoader extends ClassLoader {

    private static volatile ClassLoader instance;

    public static ClassLoader getInstance() throws IOException {
        if (instance == null) {
            synchronized(SmartContractExecutorClassLoader.class) {
                if (instance == null) {
                    instance = new SmartContractExecutorClassLoader(SmartContractDeployerClassLoader.getInstance());
                }
            }
        }
        return instance;
    }

    protected SmartContractExecutorClassLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //TODO 加载智能合约字节码
        return super.findClass(name);
    }
}
