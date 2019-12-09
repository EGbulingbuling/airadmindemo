package cn.eg.airadmindemo;

import cn.eg.airadmindemo.pojo.UmUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * Spring Data Redis测试
 *
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=AiradmindemoApplication.class)
public class RedisTest {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void testSet(){
        this.redisTemplate.opsForValue().set("key", "value");
    }


    @Test
    public void testGet(){
        String value = (String)this.redisTemplate.opsForValue().get("key");
        System.out.println(value);
    }



    /**
     * 添加Users对象
     */
    @Test
    public void testSetUesrs(){
        UmUser user = new UmUser(1,"张三","123","123","321","1","123","qqq",null,"123");
        //重新设置序列化器
        this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        this.redisTemplate.opsForValue().set("users", user);
    }

    /**
     * 取Users对象
     */
    @Test
    public void testGetUsers(){
        //重新设置序列化器
        this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        UmUser user = (UmUser)this.redisTemplate.opsForValue().get("users");
        System.out.println(user);
    }

    /**
     * 基于JSON格式存Users对象
     */
    @Test
    public void testSetUsersUseJSON(){
        UmUser user = new UmUser(1,"张三","123","123","321","1","123","qqq",null,"123");
        this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(UmUser.class));
        this.redisTemplate.opsForValue().set("users_json", user);
    }

    /**
     * 基于JSON格式取Users对象
     */
    @Test
    public void testGetUseJSON(){
        this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(UmUser.class));
        UmUser user = (UmUser)this.redisTemplate.opsForValue().get("users_json");
        System.out.println(user);
    }

    @Test
    public void testSetUseHash(){
        redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(UmUser.class));
        String key="user";
        Map<String,UmUser> map=new HashMap<>();
        UmUser user = new UmUser(1,"张三","123","123","321","1","123","qqq",null,"123");
        map.put("张三",user);
        redisTemplate.opsForHash().putAll(key, map);
    }

    @Test
    public void testGetUseHash(){
        redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(UmUser.class));
        String key="user";
        String item="张三";
        UmUser umUser= (UmUser) redisTemplate.opsForHash().get(key, item);
        System.out.println(umUser);
    }
}