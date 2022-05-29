package com.example.redis.crud.config;

import com.example.redis.crud.model.Employee;
import java.util.logging.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class MainConfig {

    @Bean
    public RedisConnectionFactory redisConnectionFactory(){
        return new LettuceConnectionFactory();
    }

    @Bean(name = "redisTemplateEmployee")
    public RedisTemplate<String, Employee> redisTemplate(){
        RedisTemplate<String,Employee> obj = new RedisTemplate<>();
        obj.setConnectionFactory(redisConnectionFactory());
        return obj;
    }

    @Scheduled(cron = "* * * * * *")
    public void scheduleFixedDelayTask(){
        Logger.getGlobal().info("Fixed delay task:" + System.currentTimeMillis() / 1000);
    }


}
