package spring.mvc.service.Impl;

/**
 * Created by Денис on 28.02.2015.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.mvc.entity.Client;
import spring.mvc.repository.ClientRepository;
import spring.mvc.service.ClientService;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository ClientRepository;

    @Override
    public Client addClient(Client Client) {
        Client savedClient = ClientRepository.saveAndFlush(Client);

        return savedClient;
    }

    @Override
    public void delete(long id) {
        ClientRepository.delete(id);
    }

    @Override
    public Client getByName(String lastname) {
        return ClientRepository.findByName(lastname);
    }

    @Override
    public Client editClient(Client Client) {
        return ClientRepository.saveAndFlush(Client);
    }

    @Override
    public List<Client> getAll() {
        return ClientRepository.findAll();
    }
}