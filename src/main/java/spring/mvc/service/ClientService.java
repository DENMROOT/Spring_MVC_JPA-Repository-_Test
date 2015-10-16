package spring.mvc.service;

import com.sun.deploy.util.SessionState;
import spring.mvc.entity.ClientEntity;

import java.util.List;

/**
 * Created by Денис on 28.02.2015.
 */
public interface ClientService {

    ClientEntity addClient(ClientEntity clientEntity);
    void delete(long id);
    ClientEntity getByName(String lastname);
    ClientEntity editClient(ClientEntity clientEntity);
    List<ClientEntity> getAll();
    ClientEntity getById(long id);
}
