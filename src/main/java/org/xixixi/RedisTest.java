package org.xixixi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void contextLoads() {
        //===============redisTemplate 操作不同的数据类型，api和我们的命令是一样的===========
        //opsForValue 操作字符串 类似于String
        //redisTemplate.opsForValue();
        //opsForList 操作List 类似于List
        //redisTemplate.opsForList();
        //opsForSet 操作Set 类似于Set
        //redisTemplate.opsForSet();
        //opsForHash 操作hash 类似于hash
        //redisTemplate.opsForHash();
        //opsForHyperLogLog 操作HyperLogLog 类似于HyperLogLog
        //redisTemplate.opsForHyperLogLog();
        //opsForZSet 操作ZSet 类似于ZSet
        //redisTemplate.opsForZSet();
        //opsForGeo 操作Geo 类似于Geo
        //redisTemplate.opsForGeo();

        //除了基本的操作，我们常用的方法都可以直接通过redisTemplate操作，比如事务，和基本的CRUD

        //获取redis 的连接对象
//        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
//        connection.flushDb();
//        connection.flushAll();
        redisTemplate.opsForValue().set("myKey","haiYang");
        System.out.println(redisTemplate.opsForValue().get("myKey"));

    }
}
