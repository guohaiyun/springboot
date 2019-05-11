//package cn.wmyskz.springboot.util.config.shiro;
//
///**
// * @author haiyun.guo
// * @Description:
// * @date 2019年05月10日 11:16
// */
//import cn.wmyskz.springboot.util.RedisUtil2;
//import org.apache.commons.lang3.SerializationUtils;
//import org.apache.shiro.session.Session;
//import org.apache.shiro.session.UnknownSessionException;
//import org.apache.shiro.session.mgt.SimpleSession;
//import org.apache.shiro.session.mgt.ValidatingSession;
//import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
//import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
//import org.apache.shiro.session.mgt.eis.SessionDAO;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.Transaction;
//
//import java.io.Serializable;
//import java.util.Base64;
//import java.util.Collection;
//
//public class RedisSessionDao extends CachingSessionDAO {
//
//    private static final String PREFIX = "SHIRO_SESSION_ID";
//
//    private static final int EXPRIE = 10000;
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(RedisSessionDao.class);
//
//    @Autowired
//    private RedisUtil2 redisTempla;
//
//    @Override
//    protected Serializable doCreate(Session session) {
//        LOGGER.info("--------doCreate-----");
//        Serializable serializable = this.generateSessionId(session);
//        assignSessionId(session, serializable);
//        session.setTimeout(EXPRIE * 1000);
//
//        redisTempla.setStringValue(PREFIX+session.getId().toString(), session);
//        /*jedis.set(getByteKey(serializable),SerializationUtils.serialize((Serializable)session));
//        jedis.expire(SerializationUtils.serialize(getByteKey(serializable)),EXPRIE);*/
////        jedis.setex(getByteKey(serializable),EXPRIE,SerializationUtils.serialize((Serializable)session) );
////        redisTemplate.setIfAbsent
//
//        return serializable;
//    }
//
//
//    @Override
//    protected Session doReadSession(Serializable serializable) {
//        LOGGER.info("--------doReadSession-----");
//        Session session = (Session) redisTempla.getStringValue(serializable.toString());
//
////        if (s != null) {
////            session = SerializationUtils.deserialize(s);
////            jedis.expire((PREFIX+serializable).getBytes(),EXPRIE);
////        }
//        //判断是否有会话  没有返回NULL
//        if (session == null) {
//            return null;
//        }
//
//        return session;
//    }
//
//    private byte[] getByteKey(Object k) {
//        if (k instanceof String) {
//            String key = PREFIX + k;
//            return key.getBytes();
//        } else {
//            return SerializationUtils.serialize((Serializable) k);
//        }
//    }
//
//    @Override
//    protected void doUpdate(Session session) {
//        LOGGER.info("--------doUpdate-----");
//        if (session == null) {
//            return;
//        }
//        session.setTimeout(EXPRIE * 1000);
//       /*jedis.set(getByteKey(session.getId()),SerializationUtils.serialize((Serializable)session));
//       jedis.expire(SerializationUtils.serialize((PREFIX+session.getId())),EXPRIE);*/
////        jedis.setex(getByteKey(session.getId()),EXPRIE,SerializationUtils.serialize((Serializable)session) );
//
//        redisTempla.setStringValue(PREFIX+session.getId().toString(), session);
//    }
//
//
//    @Override
//    protected void doDelete(Session session) {
//        LOGGER.info("--------doDelete-----");
////        Jedis jedis = JedisUtil.getJedis();
//        redisTempla.del(PREFIX+session.getId().toString());
////        JedisUtil.closeJedis(jedis);
//
//    }
//}