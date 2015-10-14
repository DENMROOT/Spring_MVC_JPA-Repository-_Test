package spring.mvc.repository;

/**
 * Created by Денис on 28.02.2015.
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.mvc.entity.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    ClientEntity findBylastName(String lastname);
}