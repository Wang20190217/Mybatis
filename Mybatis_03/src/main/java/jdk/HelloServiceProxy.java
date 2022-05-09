package jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 城南花已开<br>
 *
 * @Description: <br>
 * @Project: <br>
 * @CreateDate: Created in 2022/5/9 23:00 <br>
 * @Author: Wang
 */
public class HelloServiceProxy implements InvocationHandler {
    private Object target;

    public  Object bind(Object target){
        this.target=target;
        //取得代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("#########我是JDK动态代理##########");
        Object result=null;
        //反射方法前调用
        System.out.println("我准备说hello");
        //执行方法，相当于调用HelloServiceImpl类的sayHello方法
        result=method.invoke(target,args);
        //反射方法后调用
        System.out.println("我说过了hello了");
        return result;
    }
}
