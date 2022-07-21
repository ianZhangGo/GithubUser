package com.main.config;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

import com.main.entity.User;

@Configuration
public class RedisConfig {
	// Setting up the connection factory.
    @Bean
    RedisConnectionFactory  redisConnectionFactory() {
        return new LettuceConnectionFactory();
    }
      
    // Setting up the Redis template object. The time-to-live of Employee key is 5 seconds.
    @Bean
    public RedisTemplate<String, User> redisTemplate() {
        final RedisTemplate<String, User> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        redisTemplate.afterPropertiesSet();
        redisTemplate.expire("User", 10,TimeUnit.MINUTES);
        redisTemplate.expire("Employee", 5,TimeUnit.SECONDS);
        return redisTemplate;
    }
}
