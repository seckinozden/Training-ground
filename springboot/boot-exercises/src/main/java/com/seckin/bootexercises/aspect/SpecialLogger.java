package com.seckin.bootexercises.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SpecialLogger {

    @Around(value = "getByIdOperation()")
    public Object logGetByIdOperation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long stop = System.currentTimeMillis();
        String methodName = proceedingJoinPoint.getSignature().getName();
        System.err.println(String.format("%s runs %d ms", methodName, (stop - start)));
        return result;
    }


    @Around(value = "allControllerOperations()")
    public Object logAllControllerOperations(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long stop = System.currentTimeMillis();
        String methodName = proceedingJoinPoint.getSignature().getName();
        System.err.println(String.format("%s runs %d ms", methodName, (stop - start)));
        return result;
    }


    @Pointcut("@annotation(com.seckin.bootexercises.aspect.LogProfile)")
    public void getByIdOperation() {
    }

    @Pointcut("within(com.seckin.bootexercises.controller..*)")
    public void allControllerOperations() {

    }

}
