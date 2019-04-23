package cn.wmyskz.springboot.validate.mapper;

import cn.wmyskz.springboot.validate.entity.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2018-12-26
 */
public interface CourseMapper extends BaseMapper<Course> {
    public int getTest();
}
