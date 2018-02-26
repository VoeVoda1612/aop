package edu.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect {

    @Pointcut("execution(* *(..)) && within(edu.spring.aop.*)")
    private void allMethods() {
    }


    @Around("allMethods()")
    public Object writeLog(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("-----------------------------------------------------------------");
        Object output = null;

        for (Object object : proceedingJoinPoint.getArgs()) {
            System.out.println(object + " - " + object.getClass().getSimpleName());
        }

        System.out.println(proceedingJoinPoint.getSignature());
        System.out.println(proceedingJoinPoint.getSourceLocation());
        System.out.println(proceedingJoinPoint.getSignature().getName());
        System.out.println(proceedingJoinPoint.getSignature().getDeclaringType());
        System.out.println(proceedingJoinPoint.getSignature().getDeclaringTypeName());
        System.out.println(proceedingJoinPoint.getSignature().getModifiers());

        try {
            output = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return output;
    }


    @AfterReturning(pointcut = "allMethods()", returning = "obj")
    public void print(Object obj) {
        System.out.println(obj);

    }

}
