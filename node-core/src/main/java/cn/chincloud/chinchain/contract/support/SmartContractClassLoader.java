package cn.chincloud.chinchain.contract.support;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

public class SmartContractClassLoader extends URLClassLoader {

    public static ClassLoader getAppClassLoader(final ClassLoader parent) throws IOException {

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
        return new SmartContractClassLoader(new URL[]{file.toURL()}, parent);
    }

    public SmartContractClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }
}
