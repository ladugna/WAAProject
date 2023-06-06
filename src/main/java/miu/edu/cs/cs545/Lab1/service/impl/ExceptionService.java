package miu.edu.cs.cs545.Lab1.service.impl;

import miu.edu.cs.cs545.Lab1.aop.ExceptionAspect;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ExceptionService {
    /*public void testException() {
        throw new RuntimeException("Testing exception logging");
    }*/


        private final ExceptionAspect exceptionAspect;

        @Autowired
        public ExceptionService(ExceptionAspect exceptionAspect) {
            this.exceptionAspect=exceptionAspect;
        }

        public void testException() {
                throw new RuntimeException("Exception occurred");
        }
}
