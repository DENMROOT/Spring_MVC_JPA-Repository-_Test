package spring.mvc.service.Impl;

/**
 * Created by Денис on 28.02.2015.
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final static Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class);

    @Autowired
    private ClientRepository ClientRepository;

    @Override
    public ClientEntity addClient(ClientEntity ClientEntity) {
        LOGGER.info("Client Service request for add client: " + ClientEntity.toString());
        ClientEntity savedClientEntity = ClientRepository.save(ClientEntity);

        return savedClientEntity;
    }

    @Override
    public void delete(long id) {
        LOGGER.info("Client Service request to delete client: " + id);
        ClientRepository.delete(id);
    }

    @Override
    public ClientEntity getByName(String lastname) {
        return ClientRepository.findBylastName(lastname);
    }

    @Override
    public ClientEntity editClient(ClientEntity ClientEntity) {
        LOGGER.info("Client Service request to edit client: " + ClientEntity);
        return ClientRepository.saveAndFlush(ClientEntity);
    }

    @Override
    public List<ClientEntity> getAll() {
        LOGGER.info("Client Service request to get all clients: ");
        return ClientRepository.findAll();
    }

    @Override
    public ClientEntity getById(long id) {
        LOGGER.info("Client Service request to get client by id: " + id);
        return ClientRepository.findOne(id);
    }
}