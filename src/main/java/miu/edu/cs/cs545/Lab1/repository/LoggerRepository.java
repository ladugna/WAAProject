package miu.edu.cs.cs545.Lab1.repository;

import miu.edu.cs.cs545.Lab1.domain.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerRepository extends JpaRepository<Logger, Long> {

}
