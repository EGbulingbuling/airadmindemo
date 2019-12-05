//package cn.eg.airadmindemo.config.redis;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//import redis.clients.jedis.JedisPoolConfig;
//
///**
// * 完成对Redis的整合的一些配置
// *
// *
// */
//@Configuration
//public class RedisConfig {
//
//    /**
//     * 1.创建JedisPoolConfig对象。在该对象中完成一些链接池配置
//     * @ConfigurationProperties:会将前缀相同的内容创建一个实体。
//     */
//    @Bean
//    @ConfigurationProperties(prefix="spring.redis.pool")
//    public JedisPoolConfig jedisPoolConfig(){
//        JedisPoolConfig config = new JedisPoolConfig();
//		/*//最大空闲数
//		config.setMaxIdle(10);
//		//最小空闲数
//		config.setMinIdle(5);
//		//最大链接数
//		config.setMaxTotal(20);*/
//        System.out.println("默认值："+config.getMaxIdle());
//        System.out.println("默认值："+config.getMinIdle());
//        System.out.println("默认值："+config.getMaxTotal());
//        return config;
//    }
//
//    /**
//     * 2.创建JedisConnectionFactory：配置redis链接信息
//     */
//    @Bean
//    @ConfigurationProperties(prefix="spring.redis")
//    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig config){
//        System.out.println("配置完毕："+config.getMaxIdle());
//        System.out.println("配置完毕："+config.getMinIdle());
//        System.out.println("配置完毕："+config.getMaxTotal());
//
//        JedisConnectionFactory factory = new JedisConnectionFactory();
//        //关联链接池的配置对象
//        factory.setPoolConfig(config);
//        //配置链接Redis的信息
//        //主机地址
//		/*factory.setHostName("192.168.70.128");
//		//端口
//		factory.setPort(6379);*/
//        return factory;
//    }
//
//    /**
//     * 3.创建RedisTemplate:用于执行Redis操作的方法
//     */
//    @Bean
//    public RedisTemplate<String,Object> redisTemplate(JedisConnectionFactory factory){
//
//        RedisTemplate<String, Object> template = new RedisTemplate<>();
//        //关联
//        template.setConnectionFactory(factory);
//
//        //为key设置序列化器
//        template.setKeySerializer(new StringRedisSerializer());
//        //为value设置序列化器
//        template.setValueSerializer(new StringRedisSerializer());
//
//        return template;
//    }
//}