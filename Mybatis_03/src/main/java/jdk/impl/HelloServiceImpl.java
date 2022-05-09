package jdk.impl;

import jdk.HelloService;

/**
 * 城南花已开<br>
 *
 * @Description: <br>
 * @Project: <br>
 * @CreateDate: Created in 2022/5/9 22:59 <br>
 * @Author: Wang
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        System.out.println("hello "+name);
    }
}
