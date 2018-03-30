package com.deng.common.exception;

public class ServiceException extends RuntimeException{

    public ServiceException(String errorMsg){
        super(errorMsg);
    }

}
