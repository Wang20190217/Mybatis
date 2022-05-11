package cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 城南花已开<br>
 *
 * @Description: <br>
 * @Project: <br>
 * @CreateDate: Created in 2022/5/10 14:35 <br>
 * @Author: Wang
 */
public class HelloServiceCglib implements MethodInterceptor {

    private Object target;

    public Object getInstance(Object target){
        this.target=target;
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        //回调方法
        enhancer.setCallback(this);
        return enhancer.create();
    }


    /***
     * @Description:
     * @Param: [o, method, objects, methodProxy]
     * @Return: java.lang.Object
     * @Author: Wang
     * @Date: 2022/5/10 14:38
    */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("########我是cglib动态代理##########");
        //反射方法前调用
        System.out.println("我准备说hello");
        //执行方法，相当于调用HelloServiceImpl类的sayHello方法
        Object retrunObj=methodProxy.invokeSuper(obj,args);
        //反射方法后调用
        System.out.println("我说过了hello了");
        return retrunObj;
    }
}
