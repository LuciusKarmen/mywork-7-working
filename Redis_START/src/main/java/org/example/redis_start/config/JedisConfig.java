package org.example.redis_start.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class JedisConfig {

    @Bean
    public JedisPool jedisPool() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(128);           // 最大连接数
        poolConfig.setMaxIdle(128);            // 最大空闲连接
        poolConfig.setMinIdle(16);             // 最小空闲连接
        poolConfig.setTestOnBorrow(true);      // 借出时测试连接

        return new JedisPool(poolConfig, "localhost", 6379, 2000, null); // host, port, timeout, password
    }
}