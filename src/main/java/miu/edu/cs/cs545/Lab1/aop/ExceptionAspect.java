package miu.edu.cs.cs545.Lab1.aop;

import lombok.RequiredArgsConstructor;
import miu.edu.cs.cs545.Lab1.domain.ExceptionTable;
import miu.edu.cs.cs545.Lab1.repository.ExceptionRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Aspect
@Component
public class ExceptionAspect {
    private final ExceptionRepository exceptionRepository;

    public ExceptionAspect(ExceptionRepository exceptionRepository) {
        this.exceptionRepository = exceptionRepository;
    }

    @AfterThrowing(pointcut = "execution(* miu.edu.cs.cs545.Lab1.*.*.*.*(..))", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Exception exception) {
        String principle = "FakeUser"; // Set the fake user for now
        String operation = joinPoint.getSignature().getName();
        ExceptionTable exceptionLog = new ExceptionTable();
        exceptionLog.setDate(LocalDate.now());
        exceptionLog.setTime(LocalTime.now());
        exceptionLog.setPrinciple(principle);
        exceptionLog.setOperation(operation);
        exceptionLog.setExceptionType(exception.getClass().getSimpleName());
        exceptionRepository.save(exceptionLog);
        // Additional handling or logging for the exception
    }
}
