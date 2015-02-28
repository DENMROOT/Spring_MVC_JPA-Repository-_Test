package spring.mvc.repository;

/**
 * Created by Денис on 28.02.2015.
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.mvc.entity.Bank;
import spring.mvc.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("select c from Client c where c.lastName = :lastname")
    Client findByName(@Param("lastname") String lastname);
}