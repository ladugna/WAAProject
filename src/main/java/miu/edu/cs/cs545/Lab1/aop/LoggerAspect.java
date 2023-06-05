package miu.edu.cs.cs545.Lab1.aop;

import miu.edu.cs.cs545.Lab1.domain.Logger;
import miu.edu.cs.cs545.Lab1.repository.LoggerRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Aspect
@Component
public class LoggerAspect {

    private final LoggerRepository loggerRepository;

    @Autowired
    public LoggerAspect(LoggerRepository loggerRepository) {
        this.loggerRepository = loggerRepository;
    }

    @Before("execution(* miu.edu.cs.cs545.Lab1.service.*.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        String principle = "FakeUser"; // Set the fake user for now
        String operation = joinPoint.getSignature().getName();
        Logger logger = new Logger();
        logger.setDate(LocalDate.now());
        logger.setTime(LocalTime.now());
        logger.setPrinciple(principle);
        logger.setOperation(operation);
        loggerRepository.save(logger);
    }

   /* @AfterReturning(pointcut = "execution(* miu.edu.cs.cs545.Lab1.service.impl.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        // Perform any additional logging or post-processing here
    }*/
}
