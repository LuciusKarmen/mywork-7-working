package org.example.redis_start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import redis.clients.jedis.Jedis;

@SpringBootApplication
public class RedisStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisStartApplication.class, args);

        Jedis jedis = new Jedis("localhost");
        //取值
        jedis.set("name" , "Karmen");
        System.out.println("redis取cmd命令建立的值name:  " + jedis.get("name"));
        //建立新值
        jedis.set("app" , "CSDN");
        System.out.println("使用java新建的值app:  " + jedis.get("app"));
        System.out.println("启动成功");
    }

}
