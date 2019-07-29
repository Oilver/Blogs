package com.deng.customer.entity;

import lombok.Data;

@Data
public class User {
    private String id;

    private String username;

    private String password;

    private String profession;

    private String phone;

    private String email;

    private Integer isAdmin;

}