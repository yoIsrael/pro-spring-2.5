package com.apress.prospring2.ch15.remoting.caucho;

import com.apress.prospring2.ch15.remoting.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author aleksav
 */
public class HelloWorldClient {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "classpath*:/com/apress/prospring2/ch15/remoting/caucho/helloWorld.xml");

        HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorldService");
        System.out.println(helloWorld.getMessage());
    }
}
