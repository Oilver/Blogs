package com.deng.customer.mapper;

import com.deng.customer.web.result.UserResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapperExt extends UserMapper{

    /**
     * 注册时校验是否已存在用户名
     * @param username
     * @return
     */
    int checkUserName(String username);

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    UserResult selectLogin(@Param(value = "username") String username,
                           @Param(value = "password") String password);
}