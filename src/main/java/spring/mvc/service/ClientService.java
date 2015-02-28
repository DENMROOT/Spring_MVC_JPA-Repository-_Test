package spring.mvc.service;

import spring.mvc.entity.Client;

import java.util.List;

/**
 * Created by Денис on 28.02.2015.
 */
public interface ClientService {

    Client addClient(Client client);
    void delete(long id);
    Client getByName(String lastname);
    Client editClient(Client client);
    List<Client> getAll();
}
