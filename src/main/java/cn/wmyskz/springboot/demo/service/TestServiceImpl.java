package cn.wmyskz.springboot.demo.service;

import cn.wmyskz.springboot.demo.controller.HelloController;
import cn.wmyskz.springboot.demo.mapper.TestDaoMapper;
import cn.wmyskz.springboot.demo.entity.User;
import com.baomidou.dynamic.datasource.annotation.DS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author haiyun.guo
 * @Description:
 * @date 2018年12月25日 14:44
 */
@Service
@Transactional

public class TestServiceImpl   implements TestServiceInterface{
    @Autowired
    private TestDaoMapper dao;
    @Autowired
    private HelloController dao1;

    @Override
    public User test(User user) {
        //User user=new User();
        System.out.println(user.getCno());
        user.setCno("hah");

       return  user;
    }

    @Override
    public void test1() {
        dao.vvv();
    }

    @Override
    @DS("master")
    public void test2() {
        dao.vvv();
    }
    @Override
    @DS("slave_1")
    public void test3() {
        dao.exchange();

    }
  //  @DS("master")
    public void test4() {
//        dao1
//        mapper.exchange();
        dao.vvv();
    }
}
