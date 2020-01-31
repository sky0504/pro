package com.wb.pro.handle.reflect;

import com.wb.pro.service.Interface.HelloInterface;
import com.wb.pro.service.impl.HelloInterfaceImpl;
import com.wb.pro.util.LogPrintUtil;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: WangBin
 * @create: 2020-01-31 17:45
 **/
@SpringBootTest
public class JdkProxyExampleHandleTest {
    @Test
    public void jdkProxyTest() {
        JdkProxyExampleHandle jdk = new JdkProxyExampleHandle();
        HelloInterface helloInterface = (HelloInterface) jdk.bind(new HelloInterfaceImpl());
        helloInterface.sayHello();

        String a = helloInterface.getReturnStr("ff");
        LogPrintUtil.systemOutPrintln("获取返回结果为：" + a);
    }
}
