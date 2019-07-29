package com.deng.customer.web.request;

import com.deng.common.request.BaseRequest;
import lombok.Data;

@Data
public class UserRequest extends BaseRequest {

    private String username;

    private String password;

    private String profession;

    private String phone;

    private String email;

}
