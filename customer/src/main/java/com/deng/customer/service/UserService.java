package com.deng.customer.service;

import com.deng.common.response.Response;
import com.deng.customer.entity.User;
import com.deng.customer.web.request.LoginRequest;
import com.deng.customer.web.request.UserRequest;
import com.deng.customer.web.result.UserResult;

import java.util.List;

public interface UserService {

    /**
     * 登录
     * @return
     */
    Response<UserResult> login(LoginRequest loginRequest);

    Response<List<UserResult>> getUserList();

    Response<UserResult> getUser(String id);

    Response addUser(UserRequest userRequest);

    Response deleteUser(String id);

    Response updateUser(UserRequest userRequest);

}
