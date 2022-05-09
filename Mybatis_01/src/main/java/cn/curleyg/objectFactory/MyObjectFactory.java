package cn.curleyg.objectFactory;


import cn.curleyg.handler.MyStringTypeHandler;
import org.apache.ibatis.reflection.ReflectionException;
import org.apache.ibatis.reflection.Reflector;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.log4j.Logger;

import java.lang.reflect.Constructor;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 城南花已开<br>
 *
 * @Description: 自定义objectFactory<br>
 * @Project: <br>
 * @CreateDate: Created in 2022/5/9 05:44 <br>
 * @Author: Wang
 */
public class MyObjectFactory extends DefaultObjectFactory {
    private static final long serialVersionUID = -3855120656740914948L;
     Logger log = Logger.getLogger(MyObjectFactory.class);

     @Override
     public void setProperties(Properties properties){
         log.info("设置的属性"+properties);
         super.setProperties(properties);
     }

    @Override
    public <T> T create(Class<T> type) {
        log.info("使用定制对象工厂的create方法构建列表对象");
         return super.create(type);
    }

    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        log.info("使用定制对象工厂的create方法构建列表对象");
        return super.create(type,constructorArgTypes,constructorArgs);
    }
    public <T> boolean isCollection(Class<T> type) {
        return super.isCollection(type);
    }

}
