package cn.wmyskz.springboot.validate.service.impl;

import cn.wmyskz.springboot.validate.entity.Course;
import cn.wmyskz.springboot.validate.mapper.CourseMapper;
import cn.wmyskz.springboot.validate.service.ICourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2018-12-26
 */
@Service

public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {
    @Override
    public void test1(){
        //this.updateById(new Course());
        //baseMapper.getTest();
        //this.update(new Course(),null);
        this.list();
    }
}
