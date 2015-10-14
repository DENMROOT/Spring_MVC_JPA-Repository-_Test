package spring.mvc.service;

/**
 * Created by Денис on 28.02.2015.
 */
import spring.mvc.entity.BankEntity;

import java.util.List;

public interface BankService {

    BankEntity addBank(BankEntity bankEntity);
    void delete(long id);
    BankEntity getByName(String name);
    BankEntity editBank(BankEntity bankEntity);
    List<BankEntity> getAll();

}
