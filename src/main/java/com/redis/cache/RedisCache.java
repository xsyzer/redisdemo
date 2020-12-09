package com.redis.cache;

import com.redis.util.ApplicationContextUtils;
import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.DigestUtils;

/**
 * @author xsyz
 * @created 2020-12-09   20:51
 */
public class RedisCache implements Cache {

    /**
     *当前放入缓存的mapper的namespace
     *
     */
    private final String id;

    /**
     *必须有构造方法
     *
     */
    public RedisCache(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    /**
     * 缓存放入值
     */
    @Override
    public void putObject(Object key, Object value) {
        RedisTemplate redisTemplate = getredisTemplate();
        redisTemplate.opsForHash().put(id.toString(), getKeyMd5(key.toString()), value);
    }

    /**
     * 缓存获取值
     */
    @Override
    public Object getObject(Object key) {
        RedisTemplate redisTemplate = getredisTemplate();
        return redisTemplate.opsForHash().get(id.toString(), getKeyMd5(key.toString()));
    }

    /**
     * mybatis保留方法，没有实现，不走此方法
     *
     * @param o
     * @return
     */
    @Override
    public Object removeObject(Object o) {
        return null;
    }

    /**
     * 修改数据库时删除缓存
     */
    @Override
    public void clear() {
        RedisTemplate redisTemplate = getredisTemplate();
        redisTemplate.delete(id.toString());
    }

    /**
     * 返回缓存数量
     *
     * @return
     */
    @Override
    public int getSize() {
        RedisTemplate redisTemplate = getredisTemplate();
        return redisTemplate.opsForHash().size(id.toString()).intValue();
    }

    private RedisTemplate getredisTemplate() {
        //通过工具类获取redis
        RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        //使用hash类型作为缓存模型
        return redisTemplate;
    }
    /**
     * 对key进行md5加密
     */
    private String getKeyMd5(String key) {
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }
}
