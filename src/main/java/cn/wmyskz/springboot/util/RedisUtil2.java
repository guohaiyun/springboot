package cn.wmyskz.springboot.util;

import net.sf.jsqlparser.statement.select.SetOperationList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import redis.clients.jedis.Protocol;
import redis.clients.util.SafeEncoder;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author haiyun.guo
 * @Description:
 * @date 2019年02月14日 20:13
 */
@Component
public    class RedisUtil2 <T>{
    @Autowired
    private RedisTemplate redisTemplate;

    public boolean testRedis(){
        return true;
    }
    /*Redis操作Object部分-begin*/
    public void setStringValue(String key,Object value){
         redisTemplate.opsForValue().set(key,value);
    }

    public Object getStringValue(String key){
        return  redisTemplate.opsForValue().get(key);
    }
    /*Redis操作Object部分-begin*/

    /*Redis操作HashMap部分-begin*/
    /*
    * 将map存入key中
    * */
    public void hashPutAllValue(String key,Map map){
        redisTemplate.opsForHash().putAll(key,map);

    }
    /*
     * 对应key中存入map的键值对
     * */
    public void hashPut(String key){
        redisTemplate.opsForHash().put(key,"a","b");
    }
    /*
     * 获取对应key中存入键的值
     * */
    public Object getHashGet(String key){
       return  redisTemplate.opsForHash().get(key,"a");
    }

    /*
    * 获取key的hashMap值
    * */
    public Map getHashValue(String key){
        return redisTemplate.opsForHash().entries(key);
    }
    /**
     *
     *获取key中的所有hashKey
     */
    public Set<Object> getHashKeys(String key){
        return redisTemplate.opsForHash().keys(key);
    }
    /**
     *
     *获取key中的所有hashValue
     */
    public List<Object> getHashValues(String key){
        return redisTemplate.opsForHash().values(key);
    }

    /*
    * 获取key中hash的长度
    * */
    public long getHashLength(String key){
        return redisTemplate.opsForHash().size(key);
    }
    /*
     * 删除对应key中的键值
     * */
    public Long delHashKey(String key,Object...objects){
        return redisTemplate.opsForHash().delete(key,objects);
    }

    /*Redis操作HashMap部分-end*/



    /*Redis操作集合-list部分-begin*/

    /*
    * 对应key中左插入集合一个或多个值
    * */
    public void leftPushValue(String key,Object... obj){
        redisTemplate.opsForList().leftPush(key,obj);
    }

    /*
     * 对应key中右插入集合一个或多个值
     * */
    public void rightPushValue(String key,Object... obj){
        redisTemplate.opsForList().rightPush(key,obj);
    }

    /*
     * 对应key中右指定位置插入集合一个或多个值
     * */
    public void rightPushValue(String key,Integer start,Object obj){
        redisTemplate.opsForList().set(key,start,obj);

    }


    /*
     * 对应key中左边取出一个值
     * */
    public Object listLeftPop(String key){
        return redisTemplate.opsForList().leftPop(key);
    }
    /*
     * 对应key中右边取出一个值
     * */
    public Object listRightPop(String key){
        return redisTemplate.opsForList().rightPop(key);
    }



    /*
     * 对应key中左插入一个集合
     * */
    public void leftPushAllValue(String key,List list){
        redisTemplate.opsForList().leftPushAll(key,list);
    }

    /*
     * 对应key中右插入一个集合
     * */
    public void rightListValue(String key,List list){
        redisTemplate.opsForList().rightPushAll(key,list);
    }


    /*
     * 对应key中获取指定下标的值
     * */
    public void setListValue(String key,long index,Object object){
         redisTemplate.opsForList().set(key,index,object);
    }

    /**
     * 通过索引 获取list中的值 
     * @param key 键 
     * @param index 索引  index>=0时， 0 表头，1 第二个元素，依次类推；index<0时，-1，表尾，-2倒数第二个元素，依次类推 
     * return
     * */
    public Object rightPushValue(String key,long index){
        return redisTemplate.opsForList().index(key,index);
    }
    /*
    *获取key中的列表集合长度
    * */
    public long getListLength(Object key){
        return redisTemplate.opsForList().size(key);
    }

//    /*
//     *获取key中的列表集合列表
//     * */
//    public List<Object> getListValueByIndex(Object key,Integer start,Integer end){
//        return redisTemplate.opsForList().range(key,start,end);
//    }

    /*
     *获取key中的列表集合列表
     * */
    public List<Object> getListLength(Object key,long start,long end){
        return redisTemplate.opsForList().range(key,start,end);
    }

    /*Redis操作集合-list部分-end*/


    /*Redis操作集合-set 部分-begin*/
    /*
    *给指定key添加value到set集合中
    * */
    public void addsetValue(String key,Object...objects){
        redisTemplate.opsForSet().add(key,objects);

    }
    /*
     *给指定key添加set集合
     * */
    public void intersect(String key,Set set){
        redisTemplate.opsForSet().intersect(key,set);
    }

    /*
     *获取指定key添加set集合
     * */
    public Set getSetValue (String key){
        return redisTemplate.opsForSet().members(key);
    }


    /*
    *
    * */

    /**
     * 指定缓存失效时间
     * @param key 健
     * @param time 时间(秒)
     * @return
     *
     * */
    public boolean expire(String key,long time){
        try {
            if(time>0){
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
//            logger.error("设置失效时间异常",e);
            return false;
        }

    }
    /**
     * 获取缓存失效时间
     * @param key 健
     * @param time 时间(秒)
     * @return
     *
     * */
    public long getExpire(String key){
        return redisTemplate.getExpire(key);
    }
    /**
     * 判断key是否存在 
     * @param key 健
     * @return true 存在 false不存在 
     *
     * */

    public boolean hasKey(String key){
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
//            logger.error("获取key是否存在--> 异常",e);
            return false;
        }
    }
    /**
     * 删除缓存 
     * @param key 可以传一个值 或多个
     *
     * */
    public void del (String ...key){
        if(key!=null&&key.length>0){
            if(key.length==1){
                redisTemplate.delete(key[0]);
            }else{
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }

    }

    public void mult(Object key){
        redisTemplate.multi();
        redisTemplate.watch(key);
        List<Object>objects=redisTemplate.exec();
        if(objects==null ||objects.isEmpty()){
            System.out.println("不开心");
        }else {
            System.out.println("好开心");
        }
    }
    /*Redis 操作set部分-end*/

    /*
    *redis 管道操作
    * */
    public List<Long> executePipelined(){
       return redisTemplate.executePipelined(new RedisCallback<Long>() {
                    @Nullable
                    @Override
                    public Long doInRedis(RedisConnection connection) throws DataAccessException {
                        connection.openPipeline();
                        for (int i = 0; i < 1000000; i++) {
                            String key = "123" + i;
                            System.out.println("测试->"+connection.set(key.getBytes(),"1".getBytes()));
//                            connection.set()
                        }
                        return null;
                    }
                }, redisTemplate.getValueSerializer());
    }


    public  boolean setIfAbsent(final String key, final Serializable value, final long exptime) {
        Boolean b = (Boolean) redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer valueSerializer = redisTemplate.getValueSerializer();
                RedisSerializer keySerializer = redisTemplate.getKeySerializer();
                Object obj = connection.execute("set", keySerializer.serialize(key),
                        valueSerializer.serialize(value),
                        SafeEncoder.encode("NX"),
                        SafeEncoder.encode("EX"),
                        Protocol.toByteArray(exptime));
                return obj != null;
            }
        });
        return b;
    }

}
