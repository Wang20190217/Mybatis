package jdk;


import jdk.impl.HelloServiceImpl;

/**
 * 城南花已开<br>
 *
 * @Description: <br>
 * @Project: <br>
 * @CreateDate: Created in 2022/5/10 14:26 <br>
 * @Author: Wang
 */
public class HelloServiceMain {
    public static void main(String[] args) {
        HelloServiceProxy helloServiceProxy = new HelloServiceProxy();
        HelloService helloService = (HelloService) helloServiceProxy.bind(new HelloServiceImpl());
        helloService.sayHello("wang");
    }
}
