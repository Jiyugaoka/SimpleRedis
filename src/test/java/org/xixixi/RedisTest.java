package org.xixixi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Unit test for simple App.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest
{
    @Autowired
    @Qualifier("userRedis")
    private RedisTemplate userRedisTemplate;

    @Autowired
    private RedisUtils redisUtils;

    @Test
    public void simpleTest()
    {
        System.out.println(userRedisTemplate.opsForValue().get("ejg").toString());

        System.out.println(redisUtils.<User>getCacheObject("userObject"));
    }
}
