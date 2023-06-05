package miu.edu.cs.cs545.Lab1.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import org.springframework.stereotype.Component;

import java.util.Timer;

@Aspect
@Component
public class ExecutionTimeAspect {

@Pointcut("@annotation(miu.edu.cs.cs545.Lab1.aop.ExecutionTime)")
    public void LogMeAnnotation(){

}
    @Around("LogMeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint call) throws Throwable{
     long start= System.nanoTime();
     var action=call.proceed();
     long end=System.nanoTime();
     long totalTime=end-start;
        System.out.println(call.getSignature().getName()+ " takes : "+totalTime +"  nanoseconds ");
     return action;
    }

    @Pointcut("@annotation(miu.edu.cs.cs545.Lab1.aop.LogMe)")
    public void logU(){

    }
    @After("logU()")
    public void print(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+" finished.....");
    }

    @Before("logU()")
    public void returnIt(JoinPoint joinPoint){
    //return joinPoint.getSignature().getName()+ "  started";
        System.out.println(" started ....");
    }

}
