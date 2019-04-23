//package cn.wmyskz.springboot.upload.service;
//
//import cn.wmyskz.springboot.util.User;
//import cn.wmyskz.springboot.upload.mapper.TestDaoMapper;
//import cn.wmyskz.springboot.upload.mapper.TestMapper;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
///**
// * @author haiyun.guo
// * @Description:
// * @date 2018年12月25日 14:44
// */
//@Service
//public class ServiceImpl implements ServiceInterface{
//    @Autowired
//    private TestMapper mapper;
//
//    @Override
//    public void test() {
//        System.out.println("bean-->"+mapper);
//        List<User> user=mapper.selectList(null);
////        System.out.println(mapper.selectById());
//        System.out.println(user.get(0).getLow());
//    }
//
//}
