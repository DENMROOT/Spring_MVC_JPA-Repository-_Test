package spring.mvc.repository;

/**
 * Created by Денис on 28.02.2015.
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.mvc.entity.Client;
import spring.mvc.entity.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
    @Query("select w from Worker w where w.lastName = :lastname")
    Worker findByName(@Param("lastname") String lastname);
}