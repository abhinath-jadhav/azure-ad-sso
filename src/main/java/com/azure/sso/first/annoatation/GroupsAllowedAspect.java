package com.azure.sso.first.annoatation;

import com.azure.sso.first.controller.AdminController;
import com.azure.sso.first.utils.Utility;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Aspect
@Component
public class GroupsAllowedAspect {

    @Autowired
    private Utility utility;

    @Around("@annotation(GroupsAllowed)")
    public Object processCustomAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String accessToken = authorizationHeader.substring(7);

            String methodName = joinPoint.getSignature().getName();
            Class<?> aClass = joinPoint.getTarget().getClass();

            utility.validateGroups(accessToken, aClass,methodName);
        }
        return joinPoint.proceed();
    }

}
