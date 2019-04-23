package cn.wmyskz.springboot.transactional.mapper;

import cn.wmyskz.springboot.transactional.entity.Teacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2019-01-09
 */
public interface TeacherMapper extends BaseMapper<Teacher> {
    void test1(Teacher teacher);
}
