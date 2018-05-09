package com.deng.customer.web.controller;

import com.deng.common.Const.Const;
import com.deng.common.annotation.Check;
import com.deng.common.exception.ServiceException;
import com.deng.common.response.Response;
import com.deng.customer.service.UserService;
import com.deng.customer.web.request.LoginRequest;
import com.deng.customer.web.request.UserRequest;
import com.deng.customer.web.result.UserResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "登录")
    @RequestMapping(value = "/login",method = RequestMethod.POST,produces = Const.JOSN)
    public Response<UserResult> login(@RequestBody LoginRequest loginRequest, HttpServletRequest request){

        Response<UserResult> response = userService.login(loginRequest);
        if(null==response.getData()){
            return response;
        }
        //用于验证用户是否登录
        String token = UUID.randomUUID().toString();
        String userId = response.getData().getId();
        if(null!=request.getSession().getAttribute(userId==null?" ":userId)){
            return Response.createByErrorMessage("该用户已登录");
        }
        request.getSession().setAttribute(userId,token);
        return response;
    }

    @ApiOperation(value = "注销")
    @RequestMapping(value = "/logout",method = RequestMethod.GET,produces = Const.JOSN)
    public Response logout(@RequestParam String userId,HttpServletRequest request){
        request.getSession().removeAttribute(userId);
        return Response.createBySuccess();
    }

    @ApiOperation(value = "注册")
    @RequestMapping(value = "/user",method = RequestMethod.POST,produces = Const.JOSN)
    public Response addUser(@RequestBody UserRequest userRequest){
        return userService.addUser(userRequest);
    }

    //@Check
    @ApiOperation(value = "用户列表")
    @RequestMapping(value = "/userList",method = RequestMethod.GET,produces = Const.JOSN)
    public Response<List<UserResult>> getUserList(){
        return userService.getUserList();
    }

    //@Check
    @ApiOperation(value = "查询用户")
    @RequestMapping(value = "/user",method = RequestMethod.GET,produces = Const.JOSN)
    public Response<UserResult> getUser(@RequestParam String userId,
                                        @RequestParam String id){
        return userService.getUser(id);
    }

    //@Check
    @ApiOperation(value = "删除用户")
    @RequestMapping(value = "/user",method = RequestMethod.DELETE,produces = Const.JOSN)
    public Response deleteUser(@RequestParam String userId,
                               @RequestParam String id,
                               HttpServletRequest request){
        request.getSession().removeAttribute(userId);
        return userService.deleteUser(id);
    }

    //@Check
    @ApiOperation(value = "修改用户")
    @RequestMapping(value = "/user",method = RequestMethod.PUT,produces = Const.JOSN)
    public Response updateUser(@RequestBody UserRequest userRequest){
        return userService.updateUser(userRequest);
    }

}
