package miu.edu.cs.cs545.Lab1.aop;

import miu.edu.cs.cs545.Lab1.logging.ILogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class ExecutionTimeAspect {
  /*  @Autowired
    private ILogger logger;

    // @Pointcut("@annotation(edu.miu.springaop.aspect.annotation.ExecutionTime)")
    //    public void executionTimeAnnotation() {
    //    }
    *//*
     @Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();
        var result = proceedingJoinPoint.proceed();
        long finish = System.nanoTime();
        System.out.println(proceedingJoinPoint.getSignature().getName() + " takes ns: " + (finish - start));
        return result;
    }*//*


    //@Pointcut("@annotation(miu.edu.cs.cs545.Lab1.service.impl.UserServiceImpl)")
   *//* @Pointcut("@annotation(miu.edu.cs.cs545.Lab1.service.impl.UserServiceImpl.*(..))")
    public void executionTimeAnnotation(){

    }*//*

    @Around("execution(* miu.edu.cs.cs545.Lab1.service.impl.UserServiceImpl.*(..))")
    //@Around("execution(* service.impl.*.*(..))")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
         long start=System.nanoTime();
         var result=proceedingJoinPoint.proceed();
         long finish=System.nanoTime();
         System.out.println(proceedingJoinPoint.getSignature().getName()+
                 "  takes "+(finish-start));
         return result;
    }
    *//*
    @After("execution(* bank.dao.*.*(..))")
	public void log(JoinPoint joinpoint) {
		logger.log("Call was made to:" + joinpoint.getSignature().getName()
				+ " on " + joinpoint.getTarget().getClass());
	}*//*

    //@Before("execution(miu.edu.cs.cs545.lab1.service.impl.*.*(..)) && args(arg)")
    //@Before("execution(public * *.*.*(..))")
    @After("execution(public * *(..))")
    public void log(JoinPoint joinPoint){
       logger.log("Call was made to1:" + joinPoint.getSignature().getName()
                + " on " + joinPoint.getTarget().getClass());
    }*/
}
