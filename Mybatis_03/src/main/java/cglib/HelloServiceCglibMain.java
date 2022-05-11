package cglib;


import jdk.HelloService;
import jdk.HelloServiceProxy;
import jdk.impl.HelloServiceImpl;

/**
 * 城南花已开<br>
 *
 * @Description: <br>
 * @Project: <br>
 * @CreateDate: Created in 2022/5/10 14:26 <br>
 * @Author: Wang
 */
public class HelloServiceCglibMain {
    public static void main(String[] args) {
        HelloServiceCglib helloServiceCglib = new HelloServiceCglib();
        HelloService helloService = (HelloService) helloServiceCglib.getInstance(new HelloServiceImpl());
        helloService.sayHello("wang");
    }
}
