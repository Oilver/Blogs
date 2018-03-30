package com.deng.message.web.request;

import com.deng.common.request.BaseCheckRequest;
import lombok.Data;

import java.util.Date;

@Data
public class ReplyRequest extends BaseCheckRequest {

    private Integer floor;

    private String articleId;

    private Date updatedTime;

    private String updatedUser;

    private String content;

    private Integer lastFloor;

    private String lastUser;

}
