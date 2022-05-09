package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 城南花已开<br>
 *
 * @Description: <br>
 * @Project: <br>
 * @CreateDate: Created in 2022/5/9 22:50 <br>
 * @Author: Wang
 */
public class ReflectService {
    /***
     * @Description: 服务方法
     * @Param: [name]姓名
     * @Return: void
     * @Author: Wang
     * @Date: 2022/5/9 22:50
    */
    public void sayHello(String name){
        System.out.println("hello "+name);
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //通过反射获取到了对象
        Object service=Class.forName(ReflectService.class.getName()).newInstance();
        //获取到服务方法
        Method method=service.getClass().getMethod("sayHello",String.class);
        //调用方法
        method.invoke(service,"wang");
    }
}
