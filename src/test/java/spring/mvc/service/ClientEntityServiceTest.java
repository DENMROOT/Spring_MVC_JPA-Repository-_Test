package spring.mvc.service;

/**
 * Created by Денис on 15.10.2015.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import spring.mvc.config.TestDataBaseConfig;
import spring.mvc.entity.BankEntity;
import spring.mvc.entity.ClientEntity;
import spring.mvc.entity.WorkerEntity;
import spring.mvc.entity.enums.WorkerStatus;
import spring.mvc.util.BankUtil;
import spring.mvc.util.ClientUtil;
import spring.mvc.util.WorkerUtil;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestDataBaseConfig.class})
@WebAppConfiguration
public class ClientEntityServiceTest {

    @Autowired
    private ClientService clientService;

    ClientEntity clientEntity1;
    ClientEntity clientEntity2;

    @Before
    public void initialize(){
        clientEntity1 = clientService.addClient(ClientUtil.createClient("Denis", "Makarov", "+380(67)6138426", "Kyiv Lenina 68", "denm2000@gmail.com"));
        clientEntity2 = clientService.addClient(ClientUtil.createClient("Igor", "Pupkin", "+380(67)3332211", "Zaporizhzhya Lenina 68", "igor@gmail.com"));
    }

    @After
    public void clean(){
        if (clientService.getById(clientEntity1.getId())!=null) {
            clientService.delete(clientEntity1.getId());
        }
        if (clientService.getById(clientEntity2.getId())!=null) {
            clientService.delete(clientEntity2.getId());
        }
    }

    @Test
    public void testClientSave() throws Exception {
        assertEquals(2,clientService.getAll().size(),0);
    }

    @Test
    public void testGetClientByLastName() throws Exception {
        assertEquals(clientEntity1,clientService.getByName("Makarov"));
    }

    @Test
    public void deleteClient() throws Exception {
        clientService.delete(clientEntity2.getId());

        assertEquals(1,clientService.getAll().size(),0);
    }

    @Test
    public void updateClient() {
        clientEntity1.setLastName("Sidorov");
        clientService.editClient(clientEntity1);

        assertEquals(clientEntity1,clientService.getByName("Sidorov"));
    }
}