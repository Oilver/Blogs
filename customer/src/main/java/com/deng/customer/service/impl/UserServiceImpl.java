package com.deng.customer.service.impl;

import com.deng.common.response.Response;
import com.deng.common.utils.MD5Util;
import com.deng.customer.entity.User;
import com.deng.customer.mapper.UserMapperExt;
import com.deng.customer.service.UserService;
import com.deng.customer.web.request.LoginRequest;
import com.deng.customer.web.request.UserRequest;
import com.deng.customer.web.result.UserResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapperExt userMapperExt;

    @Override
    public Response<UserResult> login(LoginRequest loginRequest) {
        //先检查是否存在用户名
        int check = userMapperExt.checkUserName(loginRequest.getUsername());
        if (0 == check) {
            return Response.createByErrorMessage("用户名不存在");
        }
        String username = loginRequest.getUsername();
        String password = MD5Util.MD5EncodeUtf8(loginRequest.getPassword());
        //登录
        UserResult result = userMapperExt.selectLogin(username, password);
        if (null == result) {
            return Response.createByErrorMessage("密码错误");
        }
        //管理员
        if (1 == result.getIsAdmin()) {
            Response response = new Response(250);
            return response;
        }
        return Response.createBySuccess(result);
    }

    @Override
    public Response<List<UserResult>> getUserList() {
        List<UserResult> userList = userMapperExt.getUserList();
        List<UserResult> result = new ArrayList<>();
        for (UserResult u : userList
        ) {
            if (1 != u.getIsAdmin()) {
                result.add(u);
            }
        }
        return Response.createBySuccess(result);
    }

    @Override
    public Response addUser(UserRequest userRequest) {
        //先检查是否存在用户名
        int check = userMapperExt.checkUserName(userRequest.getUsername());
        if (1 == check) {
            return Response.createByErrorMessage("该用户名已存在");
        }
        User user = new User();
        BeanUtils.copyProperties(userRequest, user);
        //MD5加密
        user.setPassword(MD5Util.MD5EncodeUtf8(user.getPassword()));
        //不是管理员
        user.setIsAdmin(0);
        check = userMapperExt.insert(user);
        if (1 != check) {
            return Response.createByErrorMessage("注册失败");
        }
        return Response.createBySuccess("注册成功");
    }

    @Override
    public Response<UserResult> getUser(String id) {
        User user = userMapperExt.selectByPrimaryKey(id);
        if (null == user) {
            return Response.createByErrorMessage("不存在该用户!");
        }
        UserResult result = new UserResult();
        //复制信息
        BeanUtils.copyProperties(user, result);
        return Response.createBySuccess(result);
    }

    @Override
    public Response deleteUser(String id) {
        userMapperExt.deleteByPrimaryKey(id);
        return Response.createBySuccess("删除成功");
    }

    @Override
    public Response updateUser(UserRequest userRequest) {
        User user = new User();
        BeanUtils.copyProperties(userRequest, user);
        userMapperExt.updateByPrimaryKeySelective(user);
        return Response.createBySuccess("修改成功");
    }
}
