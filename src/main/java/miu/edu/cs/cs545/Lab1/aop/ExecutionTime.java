package miu.edu.cs.cs545.Lab1.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface ExecutionTime {
    //Transaction Id, Date, Time, Principle, Operation


}
