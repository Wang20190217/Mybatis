package cn.curleyg.cache;

import org.apache.ibatis.cache.Cache;

import java.util.concurrent.locks.ReadWriteLock;

/**
 * 城南花已开<br>
 *
 * @Description: <br>
 * @Project: <br>
 * @CreateDate: Created in 2022/5/9 20:43 <br>
 * @Author: Wang
 */
public class MyCache implements Cache {
    private String id;

    public MyCache(String id){
        this.id = id;
        System.out.println("当前加入缓存的namespace" + id);
    }
    @Override
    public String getId() {
        return id;
    }
    //放入缓存
    @Override
    public void putObject(Object key, Object value) {
        System.out.println("key的值为: " + key );
        System.out.println("value的值为: " + value );
    }
    //在缓存中获取
    @Override
    public Object getObject(Object key) {
        return null;
    }
    //删除缓存中数据
    @Override
    public Object removeObject(Object key) {
        return null;
    }
    //清空缓存
    @Override
    public void clear() {
    }
    //缓存命中率计算
    @Override
    public int getSize() {
        return 0;
    }
    //读写锁
    @Override
    public ReadWriteLock getReadWriteLock() {
        //ReadWriteLock=====>接口
        return null;
    }

}
