package com.sunny.sportwomen.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User {

    private Integer id;

    private String username;

    private String password;

    private String role;

    private String avatar;

    private String nickname;
}
