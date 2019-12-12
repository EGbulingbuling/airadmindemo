package cn.eg.airadmindemo.util;

import cn.eg.airadmindemo.pojo.TicketInfo;
import cn.eg.airadmindemo.pojo.TsTakeperson;
import cn.eg.airadmindemo.pojo.UmUser;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CacheUtil {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public UmUser getUser(String usernaem){
        redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(UmUser.class));
        UmUser user = (UmUser)this.redisTemplate.opsForHash().get("USER_NAME", usernaem);
        return user;
    }

    public void addUser(String usernaem,UmUser user){
        redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(UmUser.class));
        Map<String,UmUser> map=new HashMap<>();
        map.put(usernaem,user);
        this.redisTemplate.opsForHash().putAll("USER_NAME", map);
    }

    public TsTakeperson getTakeperson(String PersonId){
        redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(TsTakeperson.class));
        TsTakeperson tsTakeperson=(TsTakeperson)this.redisTemplate.opsForHash().get("TAKEPERSON", PersonId);
        return tsTakeperson;
    }

    public void addTakeperson(String PersonId,TsTakeperson tsTakeperson){
        redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(TsTakeperson.class));
        Map<String,TsTakeperson> map=new HashMap<>();
        map.put(PersonId,tsTakeperson);
        this.redisTemplate.opsForHash().putAll("TAKEPERSON", map);
    }

    public List<TicketInfo> getTicketInfo(String username){
        redisTemplate.setHashValueSerializer(new StringRedisSerializer());
        String ticketInfosStr= (String) this.redisTemplate.opsForHash().get("TICKET_INFO", username);
        List<TicketInfo> ticketInfos=JSONArray.parseArray(ticketInfosStr,TicketInfo.class);
        return ticketInfos;
    }

    public void addTicketInfo(String username,List<TicketInfo> ticketInfos){
        redisTemplate.setHashValueSerializer(new StringRedisSerializer());
        Map<String,String> map=new HashMap<>();
        String ticketInfosStr= JSON.toJSONString(ticketInfos);
        map.put(username,ticketInfosStr);
        this.redisTemplate.opsForHash().putAll("TICKET_INFO", map);
    }

    public void deleteTicketInfo(String username){
        redisTemplate.setHashValueSerializer(new StringRedisSerializer());
        this.redisTemplate.opsForHash().delete("TICKET_INFO", username);
    }
}
