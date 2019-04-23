package cn.wmyskz.springboot.jedis.controller;


import cn.wmyskz.springboot.util.RedisUtil2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2019-02-12
 */
@RestController
@RequestMapping("/jedis/redis")
public class RedisController {
    @Autowired
    private RedisUtil2 redisTemplate;
//    @Autowired
//    private RedisTemplate redisTemplate;
    @RequestMapping("/getUser")
    public void helloTestMap() {
//        redisTemplate.setStringValue("test","1");
        Map map=new HashMap();
        map.put("a","b");
        map.put("c","d");
        redisTemplate.hashPutAllValue("test1",map);

        Map map1=redisTemplate.getHashValue("test1");
        System.out.println(map1.get("a"));

    }
    @RequestMapping("/getUser2")
    public void helloTestMapKeys() {

        Map map=new HashMap();
        map.put("a","b");
        map.put("c","d");
        redisTemplate.hashPutAllValue("test1",map);

        Set<String> set=redisTemplate.getHashKeys("test1");
        System.out.println(set.iterator().next().equals("a"));

    }

    @RequestMapping("/getUser3")
    public void helloTestMapValues() {

        Map map=new HashMap();
        map.put("a","b");
        map.put("c","d");
        redisTemplate.getHashValues("test1");

        List<String> list=redisTemplate.getHashValues("test1");
        System.out.println(list.iterator().next().equals("b"));

    }

    @RequestMapping("/getUser4")
    public void helloTestLeftList() {

        List<String>list=new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        redisTemplate.leftPushAllValue("testList",list);

        System.out.println("list长度-->"+redisTemplate.getListLength("testList"));
        List<Object>list1=redisTemplate.getListLength("testList",0,redisTemplate.getListLength("testList"));
        list1.forEach(System.out::println);
        System.out.println(""+redisTemplate.getListLength("testList",0,2).size());
        System.out.println(redisTemplate.listLeftPop("testList"));
        System.out.println(redisTemplate.listRightPop("testList"));
//        System.out.println(list.iterator().next().equals("b"));

    }
}
