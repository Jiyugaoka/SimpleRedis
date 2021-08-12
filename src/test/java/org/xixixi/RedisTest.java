package org.xixixi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private RedisTemplate<String, User> userRedisTemplate;

    @Autowired
    private RedisTemplate<String, Object> objectRedisTemplate;

    @Test
    public void simpleTest()
    {
        redisTemplate.opsForValue().set("myKey", "ejg");
        System.out.println(redisTemplate.opsForValue().get("myKey"));

        userRedisTemplate.opsForValue().set("ejg",
                new User() {{setName("ejg");
                    setGender("male");
                    setAge(18);}});
        System.out.println(userRedisTemplate.opsForValue().get("ejg").toString());
//        有问题待修复
//        objectRedisTemplate.opsForValue().set("xixixi",
//                new User() {{setName("xixixi");
//                    setGender("male");
//                    setAge(20);}});
//        User xixixi = (User) objectRedisTemplate.opsForValue().get("xixixi");
//        System.out.println(xixixi.toString());
    }
}
