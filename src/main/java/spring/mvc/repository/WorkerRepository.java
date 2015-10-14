package spring.mvc.repository;

/**
 * Created by Денис on 28.02.2015.
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.mvc.entity.WorkerEntity;

public interface WorkerRepository extends JpaRepository<WorkerEntity, Long> {
    @Query("select w from WorkerEntity w where w.lastName = :lastname")
    WorkerEntity findByName(@Param("lastname") String lastname);
}