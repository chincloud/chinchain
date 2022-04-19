package cn.chincloud.chinchain;

import cn.chincloud.chinchain.contract.support.SmartContractClassLoader;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class BootApplicationTests {

    @Test
    void contextLoads() throws IOException, ClassNotFoundException {
        Class<?> aClass = SmartContractClassLoader.getAppClassLoader(this.getClass().getClassLoader()).loadClass("cn.chincloud.chinchain.user.TestContract");
        System.out.println(aClass);
    }

}
