package cn.wmyskz.springboot.cookie_session.service.impl;

import cn.wmyskz.springboot.cookie_session.entity.Student;
import cn.wmyskz.springboot.cookie_session.mapper.StudentMapper;
import cn.wmyskz.springboot.cookie_session.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2018-12-29
 */
@Service

public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Override
    @Transactional(propagation =Propagation.NESTED)
    public void test1() {

        Student student=new Student();
        student.setSno("1111111111111");
//        student.setClassRoom("afsa");
        this.save(student);
        int i=1/0;
    }
}
