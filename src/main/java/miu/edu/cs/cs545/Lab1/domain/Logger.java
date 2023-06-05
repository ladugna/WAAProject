package miu.edu.cs.cs545.Lab1.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Logger {
    /*
    * 1-	Make a ‘Logger’ database table that will
    * store all the operations executed in your project.
    *  The table should hold the following information
    * (Transaction Id, Date, Time, Principle, Operation).
  Since there is no authentication, you may define a
* fake static user for the principle and add it to every operation.
* This will be removed on the next lab. You may optionally add any
* suitable attribute.
*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private LocalTime time;
    private String principle;
    private String operation;


}
