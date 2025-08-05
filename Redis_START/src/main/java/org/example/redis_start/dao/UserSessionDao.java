package org.example.redis_start.dao;

import org.example.redis_start.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserSessionDao {

    private static final String USER_KEY_PREFIX = "user:info:";
    private static final String SESSION_KEY_PREFIX = "user:session:";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void saveSession(String userId, String token) {
        redisTemplate.opsForValue().set(SESSION_KEY_PREFIX + userId, token);
    }

    public String getSession(String userId) {
        return (String) redisTemplate.opsForValue().get(SESSION_KEY_PREFIX + userId);
    }

    public void deleteSession(String userId) {
        redisTemplate.delete(SESSION_KEY_PREFIX + userId);
    }

    public void saveUser(User user) {
        redisTemplate.opsForValue().set(USER_KEY_PREFIX + user.getUserId(), user);
    }


    public User getUser(String userId) {
        return (User) redisTemplate.opsForValue().get(USER_KEY_PREFIX + userId);
    }


    public void deleteUser(String userId) {
        redisTemplate.delete(USER_KEY_PREFIX + userId);
    }
}
//有机会可以使用
//    private final JedisPool jedisPool;
//
//    public UserSessionDao(JedisPool jedisPool) {
//        this.jedisPool = jedisPool;
//    }
//    public String getSession(String userId) {
//        try (Jedis jedis = jedisPool.getResource()) {
//            return jedis.get(KEY_PREFIX + userId);
//        }
//    }

