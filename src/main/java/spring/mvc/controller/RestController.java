package spring.mvc.controller;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/client/{lastName}", method = RequestMethod.GET)
    public ResponseEntity<ClientEntity> getMovie(@PathVariable String lastName, ModelMap model) {
        LOGGER.info("Receive rest request for: " + lastName + " lastName.");
        ClientEntity findedClient = clientService.getByName(lastName);
        if (findedClient != null) {
            return new ResponseEntity(findedClient, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);

    }

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public ResponseEntity<List<ClientEntity>> getDefaultMovie(ModelMap model) {
        LOGGER.info("Receive rest request for: " + "ALL" + " lastName.");
        List<ClientEntity> clientsList = clientService.getAll();

        return new ResponseEntity(clientsList, HttpStatus.OK);

    }

}
