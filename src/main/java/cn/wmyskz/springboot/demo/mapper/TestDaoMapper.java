package cn.wmyskz.springboot.demo.mapper;

import cn.wmyskz.springboot.demo.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author haiyun.guo
 * @Description:
 * @date 2018年12月25日 14:47
 */
@Component
public interface TestDaoMapper extends BaseMapper<User> {
    public void why();
    public int test();
    public int vvv();
    public User zzz();
    public List<Map> exchange();
}
