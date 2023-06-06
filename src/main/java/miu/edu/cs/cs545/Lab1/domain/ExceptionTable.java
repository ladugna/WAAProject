package miu.edu.cs.cs545.Lab1.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class ExceptionTable {
    /*
    *
3-	Make an ‘ExceptionTable’ database table that will track all
* the exceptions that were thrown (Transaction Id, Date, Time, Principle, Operation, ExceptionTable Type).
Add a method that throws an exception to test it.
*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    private LocalDate date;
    private LocalTime time;
    private String principle;
    private String operation;
    private String exceptionType;
}
