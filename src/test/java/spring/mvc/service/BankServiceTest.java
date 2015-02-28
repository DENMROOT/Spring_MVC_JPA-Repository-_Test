package spring.mvc.service;

/**
 * Created by Денис on 28.02.2015.
 */

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import spring.mvc.config.TestDataBaseConfig;
import spring.mvc.entity.Bank;
import spring.mvc.entity.Client;
import spring.mvc.entity.Worker;
import spring.mvc.entity.enums.WorkerStatus;
import spring.mvc.util.BankUtil;
import spring.mvc.util.ClientUtil;
import spring.mvc.util.WorkerUtil;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestDataBaseConfig.class})
@WebAppConfiguration
public class BankServiceTest {

    @Resource
    private EntityManagerFactory emf;
    protected EntityManager em;

    @Resource
    private BankService bankService;
    @Resource
    private ClientService clientService;
    @Resource
    private WorkerService workerService;

    @Before
    public void setUp() throws Exception {
        em = emf.createEntityManager();
    }

    @Test
    public void testSaveBank() throws Exception {
        Bank bank = bankService.addBank(BankUtil.createBank("My First Bank"));
        Client client1 = clientService.addClient(ClientUtil.createClient("Denis", "Makarov", "+380(67)6138426", "Kyiv Lenina 68", "denm2000@gmail.com", bank));
        Client client2 = clientService.addClient(ClientUtil.createClient("Igor", "Pupkin", "+380(67)3332211", "Zaporizhzhya Lenina 68", "igor@gmail.com", bank));

        Worker worker1 = workerService.addWorker(WorkerUtil.createWorker("Igor", "Vasechkin", WorkerStatus.MANAGER, "+380(67)3332211", bank));
        Worker worker2 = workerService.addWorker(WorkerUtil.createWorker("Masha", "Polina", WorkerStatus.MANAGER,"+380(67)3332211", bank));
        Worker worker3 = workerService.addWorker(WorkerUtil.createWorker("Ivan", "Ivanich", WorkerStatus.BRANCH_MANAGER, "+380(67)0001107", bank));

        System.out.println(bankService.getByName("My First Bank").getName());
        System.out.println(clientService.getByName("Makarov").getLastName());
        System.out.println(clientService.getByName("Pupkin").getLastName());
        System.out.println(workerService.getByName("Vasechkin").getLastName());
        System.out.println(workerService.getByName("Polina").getLastName());
        System.out.println(workerService.getByName("Ivanich").getLastName());
    }
}