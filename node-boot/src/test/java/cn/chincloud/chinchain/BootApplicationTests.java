package cn.chincloud.chinchain;

import cn.chincloud.chinchain.contract.support.classloader.SmartContractDeployerClassLoader;
import cn.chincloud.chinchain.contract.support.classloader.SmartContractExecutorClassLoader;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;

@SpringBootTest
public class BootApplicationTests {

    @Test
    void contextLoads() throws IOException, ClassNotFoundException {
        ClassLoader appClassLoader = SmartContractDeployerClassLoader.getInstance();
        System.out.println(appClassLoader.getParent());

        Class<?> aClass = appClassLoader.loadClass("cn.chincloud.chinchain.user.Test01SmartContract");
        InputStream input = appClassLoader.getResourceAsStream("cn.chincloud.chinchain.user.Test01SmartContract");
        byte[] bytes = StreamUtils.copyToByteArray(input);
        System.out.println(bytes.length);


        appClassLoader = SmartContractExecutorClassLoader.getInstance();
        System.out.println(appClassLoader.getParent());

    }

}
