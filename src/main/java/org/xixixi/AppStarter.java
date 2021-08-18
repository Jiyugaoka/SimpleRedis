package org.xixixi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class AppStarter {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AppStarter.class, args);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }

        RedisTemplate<String, User> userRedisTemplate = context.getBean("userRedis", RedisTemplate.class);
        userRedisTemplate.opsForValue().set("ejg",
                new User() {{setName("ejg");
                    setGender("male");
                    setAge(18);}});
        System.out.println(userRedisTemplate.opsForValue().get("ejg").toString());

        RedisUtils redisUtils = context.getBean("redisUtils", RedisUtils.class);
        redisUtils.setCacheObject("myKey", "ejg");
        System.out.println(redisUtils.<String>getCacheObject("myKey"));

        redisUtils.setCacheObject("userObject",
                new User() {{setName("ejg");
                    setGender("male");
                    setAge(19);}});
        System.out.println(redisUtils.<User>getCacheObject("userObject"));
    }
}
