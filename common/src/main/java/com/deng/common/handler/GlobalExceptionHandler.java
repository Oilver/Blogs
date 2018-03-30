package com.deng.common.handler;

import com.deng.common.exception.ServiceException;
import com.deng.common.response.Response;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Response handlerException(Exception e){
        return Response.createByErrorMessage(e.getMessage());
    }

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public Response handlerServiceException(ServiceException e){
        return Response.createByErrorMessage(e.getMessage());
    }

}
