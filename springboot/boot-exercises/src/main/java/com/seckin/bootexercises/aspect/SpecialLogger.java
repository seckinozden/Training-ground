package com.seckin.bootexercises.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SpecialLogger {

    @Around(value = "getByIdOperation() || allControllerOperations()")
    public Object logGetByIdOperation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long stop = System.currentTimeMillis();
        String methodName = proceedingJoinPoint.getSignature().getName();
        System.err.println(String.format("##  ATTENTION  ## %s runs %d ms", methodName, (stop - start)));
        return result;
    }

    @Before(value = "getByIdOperation()")
    public void logBeforeGetByIdOperation() {
        System.err.println("##  ATTENTION  ## I am working before the execution of the getByIdOperation() aspects");
    }

    @After(value = "getByIdOperation()")
    public void logAfterGetByIdOperation() {
        System.err.println("##  ATTENTION  ## I am working after the execution of the getByIdOperation() aspects");
    }

    @Pointcut("@annotation(com.seckin.bootexercises.aspect.LogProfile)")
    public void getByIdOperation() {
    }

    @Pointcut("within(com.seckin.bootexercises.controller..*)")
    public void allControllerOperations() {

    }

}
