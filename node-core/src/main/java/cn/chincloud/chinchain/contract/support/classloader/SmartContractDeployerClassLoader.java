package cn.chincloud.chinchain.contract.support.classloader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;

public class SmartContractDeployerClassLoader extends URLClassLoader {


    private static volatile ClassLoader instance;

    public static ClassLoader getInstance() throws IOException {
        if (instance == null) {
            synchronized(SmartContractDeployerClassLoader.class) {
                if (instance == null) {
                    instance = createClassLoader(SmartContractDeployerClassLoader.getSystemClassLoader());
                }
            }
        }
        return instance;
    }

    private static ClassLoader createClassLoader(final ClassLoader parent) throws IOException {

        String path = new Object() {
            public String getPath() {
                return this.getClass().getResource("/").getPath();
            }
        }.getPath().substring(1);
        path = path.replace("node-boot", "smart-contract");
        path = path.substring(0, path.lastIndexOf("/"));
        path = path.substring(0, path.lastIndexOf("/"));
        path += "/smart-contract-0.0.1-SNAPSHOT.jar";
        File file = new File(path);
        return new SmartContractDeployerClassLoader(new URL[]{file.toURI().toURL()}, parent);
    }

    @Override
    public InputStream getResourceAsStream(String name) {
        String path = name.replace('.', '/').concat(".class");
        return super.getResourceAsStream(path);
    }

    protected SmartContractDeployerClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }
}
