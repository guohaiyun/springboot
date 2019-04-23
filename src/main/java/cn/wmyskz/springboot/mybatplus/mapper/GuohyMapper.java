package cn.wmyskz.springboot.mybatplus.mapper;

import cn.wmyskz.springboot.mybatplus.entity.Guohy;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2018-12-27
 */
public interface GuohyMapper extends BaseMapper<Guohy> {
    void search();
}
