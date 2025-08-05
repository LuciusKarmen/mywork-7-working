package org.example.redis_start.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class User {

    private String userId;
    private String username;
    private String email;
    private String age;
}
