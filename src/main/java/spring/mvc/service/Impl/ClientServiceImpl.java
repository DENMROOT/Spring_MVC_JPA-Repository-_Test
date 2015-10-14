package spring.mvc.service.Impl;

/**
 * Created by Денис on 28.02.2015.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.mvc.entity.ClientEntity;
import spring.mvc.repository.ClientRepository;
import spring.mvc.service.ClientService;

import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository ClientRepository;

    @Override
    public ClientEntity addClient(ClientEntity ClientEntity) {
        ClientEntity savedClientEntity = ClientRepository.save(ClientEntity);

        return savedClientEntity;
    }

    @Override
    public void delete(long id) {
        ClientRepository.delete(id);
    }

    @Override
    public ClientEntity getByName(String lastname) {
        return ClientRepository.findBylastName(lastname);
    }

    @Override
    public ClientEntity editClient(ClientEntity ClientEntity) {
        return ClientRepository.saveAndFlush(ClientEntity);
    }

    @Override
    public List<ClientEntity> getAll() {
        return ClientRepository.findAll();
    }
}