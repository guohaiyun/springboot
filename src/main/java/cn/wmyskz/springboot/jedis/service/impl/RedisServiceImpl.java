package cn.wmyskz.springboot.jedis.service.impl;

import cn.wmyskz.springboot.jedis.entity.Redis;
import cn.wmyskz.springboot.jedis.mapper.RedisMapper;
import cn.wmyskz.springboot.jedis.service.IRedisService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2019-02-12
 */
@Service
public class RedisServiceImpl extends ServiceImpl<RedisMapper, Redis> implements IRedisService {

}
