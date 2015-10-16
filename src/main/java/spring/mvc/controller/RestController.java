package spring.mvc.controller;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMethod;
import spring.mvc.entity.ClientEntity;
import spring.mvc.service.ClientService;

import java.util.List;

/**
 * Created by DENM on 14.10.2015.
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {
    private final static Logger LOGGER = LoggerFactory.getLogger(RestController.class);

    @Autowired
    ClientService clientService;

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public ResponseEntity<List<ClientEntity>> getAllClients(ModelMap model) {
        LOGGER.info("Receive getAllClients rest request for: " + "ALL" + " lastName.");
        List<ClientEntity> clientsList = clientService.getAll();

        return new ResponseEntity(clientsList, HttpStatus.OK);

    }

    @RequestMapping(value = "/clients/{id}", method = RequestMethod.GET)
     public ResponseEntity<ClientEntity> getClientById(@PathVariable long id, ModelMap model) {
        LOGGER.info("Receive getClientById rest request for: " + id + " id.");
        ClientEntity client = clientService.getById(id);
        if (client != null) {
            LOGGER.info("Requested client founded: " + client.toString());
            return new ResponseEntity(client, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);

    }
//
//    @RequestMapping(value = "/clients/{lastName}", method = RequestMethod.GET)
//    public ResponseEntity<ClientEntity> getClientByLastName(@PathVariable String lastName, ModelMap model) {
//        LOGGER.info("Receive getClientByLastName rest request for: " + lastName + " lastName.");
//        ClientEntity findedClient = clientService.getByName(lastName);
//        if (findedClient != null) {
//            return new ResponseEntity(findedClient, HttpStatus.OK);
//        }
//        return new ResponseEntity(HttpStatus.NOT_FOUND);
//
//    }

    @RequestMapping(value = "/clients", method = RequestMethod.POST)
    public ResponseEntity<ClientEntity> addNewClient(@RequestBody ClientEntity clientEntity, ModelMap model) {
        LOGGER.info("Receive addNewClient rest request for add new Client: " + clientEntity.toString() + " client");
        if (clientEntity != null) {
            ClientEntity client = clientService.addClient(clientEntity);
            return new ResponseEntity(client, HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);

    }

    @RequestMapping(value = "/clients/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ClientEntity> updateClient(@PathVariable long id,
                                                     @RequestBody ClientEntity clientEntity,
                                                     ModelMap model) {
        LOGGER.info("Receive updateClient rest request for: " + id + " id.");
        ClientEntity client = clientEntity;
        if (client != null) {
            clientService.editClient(client);
            return new ResponseEntity(client, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/clients/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ClientEntity> deleteClient(@PathVariable long id,
                                                     ModelMap model) {
        LOGGER.info("Receive deleteClient rest delete request for: " + id + " id.");
        clientService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
