package spring.mvc.service;

/**
 * Created by Денис on 28.02.2015.
 */
import spring.mvc.entity.Bank;

import java.util.List;

public interface BankService {

    Bank addBank(Bank bank);
    void delete(long id);
    Bank getByName(String name);
    Bank editBank(Bank bank);
    List<Bank> getAll();

}
