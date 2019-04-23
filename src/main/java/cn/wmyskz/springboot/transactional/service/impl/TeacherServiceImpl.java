package cn.wmyskz.springboot.transactional.service.impl;

import cn.wmyskz.springboot.cookie_session.service.IStudentService;
import cn.wmyskz.springboot.mybatplus.entity.Guohy;
import cn.wmyskz.springboot.mybatplus.service.impl.GuohyServiceImpl;
import cn.wmyskz.springboot.transactional.entity.Teacher;
import cn.wmyskz.springboot.transactional.mapper.TeacherMapper;
import cn.wmyskz.springboot.transactional.service.ITeacherService;
import cn.wmyskz.springboot.util.SpringUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-01-09
 */
@Service
@Transactional
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements ITeacherService {

    @Autowired
    private IStudentService studentService;
    @Autowired
    private TeacherMapper mapper;

    @Override
    @Transactional
    public void test(){

            Teacher teacher=new Teacher();
            teacher.setTname("cccccccc");
            teacher.setTno("vvxV"+System.currentTimeMillis());
            this.save(teacher);
            TeacherServiceImpl imp=SpringUtil.getBean(TeacherServiceImpl.class);
        imp.test1();

//        Guohy guohy=new Guohy();
//        guohy.setName("cccccccccccc");
//        guohy.setId(155);
//        imp.save(guohy);

//                        int i=1/0;


        System.out.println(1/0);

//            studentService.test1();

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void test1(){
//
//        TeacherServiceImpl imp=beanFactory.getBean(TeacherServiceImpl.class);

            Teacher teacher1=new Teacher();
            teacher1.setTno("zzzz"+System.currentTimeMillis());
                teacher1.setTname("zzzz");
            this.save(teacher1);
    }
}
