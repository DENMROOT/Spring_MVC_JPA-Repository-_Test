package spring.mvc.repository;

/**
 * Created by Денис on 28.02.2015.
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.mvc.entity.BankEntity;

public interface BankRepository extends JpaRepository<BankEntity, Long> {
    @Query("select b from BankEntity b where b.name = :name")
    BankEntity findByName(@Param("name") String name);
}