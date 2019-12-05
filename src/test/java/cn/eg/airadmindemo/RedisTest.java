package cn.eg.airadmindemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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



//    /**
//     * 添加Users对象
//     */
//    @Test
//    public void testSetUesrs(){
//        Users users = new Users();
//        users.setAge(20);
//        users.setName("张三丰");
//        users.setId(1);
//        //重新设置序列化器
//        this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
//        this.redisTemplate.opsForValue().set("users", users);
//    }
//
//    /**
//     * 取Users对象
//     */
//    @Test
//    public void testGetUsers(){
//        //重新设置序列化器
//        this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
//        Users users = (Users)this.redisTemplate.opsForValue().get("users");
//        System.out.println(users);
//    }
//
//    /**
//     * 基于JSON格式存Users对象
//     */
//    @Test
//    public void testSetUsersUseJSON(){
//        Users users = new Users();
//        users.setAge(20);
//        users.setName("李四丰");
//        users.setId(1);
//        this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
//        this.redisTemplate.opsForValue().set("users_json", users);
//    }
//
//    /**
//     * 基于JSON格式取Users对象
//     */
//    @Test
//    public void testGetUseJSON(){
//        this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Users.class));
//        Users users = (Users)this.redisTemplate.opsForValue().get("users_json");
//        System.out.println(users);
//    }
}