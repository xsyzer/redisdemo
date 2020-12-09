package com.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author xsyz
 * @created 2020-12-09   15:49
 */
@SpringBootTest(classes = RedisApplication.class)

public class RedisTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testString() {
    }

    @Test
    public void testList() {
        stringRedisTemplate.opsForList().leftPop("name1");
        stringRedisTemplate.opsForList().range("name1", 0, -1).forEach(System.out::println);
    }

    @Test
    public void testSet() {
        stringRedisTemplate.opsForSet().add("sets", "1", "1", "2");

    }

    @Test
    public void testHash() {
        stringRedisTemplate.opsForHash().put("maps", "name2", "张三");
        stringRedisTemplate.opsForHash().put("maps", "name3", "李四");
        stringRedisTemplate.opsForHash().get("maps", "name2");
        stringRedisTemplate.opsForHash().values("maps").forEach(System.out::println);
        stringRedisTemplate.opsForHash().keys("maps").forEach(System.out::println);
    }

    @Test
    public void testBound() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        BoundValueOperations name = redisTemplate.boundValueOps("name");

    }

}
