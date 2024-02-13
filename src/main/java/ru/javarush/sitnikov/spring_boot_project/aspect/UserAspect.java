package ru.javarush.sitnikov.spring_boot_project.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import ru.javarush.sitnikov.spring_boot_project.dto.UserDto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Aspect
@Component
public class UserAspect {

    @Pointcut("within(ru.javarush.sitnikov.spring_boot_project.service.*)")
    public void allMethodsPointcut(){}

    @Pointcut("execution(public * ru.javarush.sitnikov.spring_boot_project.service.UserService.save(..))")
    public void callAllMyServicePublic(){}


//    @Before("allMethodsPointcut()")
//    public void loggingAdvice() {
//        System.out.println("executing before method invoke");
//    }

//    @Before("callAllMyServicePublic()")
//    public void beforeCallAllMethod(JoinPoint jp) {
//        String args = Arrays.stream(jp.getArgs())
//                .map(Object::toString)
//                .collect(Collectors.joining(","));
//
//        System.out.println("before " + jp + ", args=["+args+"]");
//    }
//
//    @After("callAllMyServicePublic()")
//    public void afterCallAllMethod(JoinPoint jp) {
//        System.out.println("after "+jp.getSignature().getName());
//    }

//    @Around("within(ru.javarush.sitnikov.spring_boot_project.service.*)")
//    public List<UserDto> aroundAdvice(ProceedingJoinPoint joinPoint) {
//        System.out.println("Before invoking method "+ joinPoint.getSignature());
//
//        Object value = null;
//        try {
//            value = joinPoint.proceed();
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
//        System.out.println("After invoking method."+value);
//        return (List<UserDto>) value;
//    }
}
