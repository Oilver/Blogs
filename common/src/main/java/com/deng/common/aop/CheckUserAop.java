package com.deng.common.aop;

import com.deng.common.request.BaseCheckRequest;
import com.deng.common.response.Response;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Aop判断是否在登录，鉴权作用
 */
@Component
@Aspect
public class CheckUserAop {

    @Pointcut("@annotation(com.deng.common.annotation.Check)")
    public void pointCut(){
    }

    @Around("pointCut()")
    public Object checkAuth(ProceedingJoinPoint joinPoint) throws Throwable {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        Object[] paramValues = joinPoint.getArgs();
        String[] paramNames = ((CodeSignature) joinPoint.getSignature()).getParameterNames();
        for (int i = 0;i < paramValues.length;i++){
            if(paramNames[i].equals("userId")){
                if(null == request.getSession().getAttribute((String)paramValues[i])){
                    return Response.createByErrorMessage("您还没登录，请先登录！");
                }
                break;
            }
            if (paramValues[i] instanceof BaseCheckRequest){
                BaseCheckRequest baseCheckRequest = (BaseCheckRequest)paramValues[i];
                if(null == request.getSession().getAttribute(baseCheckRequest.getUserId())){
                    return Response.createByErrorMessage("您还没登录，请先登录！");

                }
                break;
            }
        }
        return joinPoint.proceed();
    }
}
