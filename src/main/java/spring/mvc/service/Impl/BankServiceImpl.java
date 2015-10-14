package spring.mvc.service.Impl;

/**
 * Created by Денис on 28.02.2015.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.mvc.entity.BankEntity;
import spring.mvc.repository.BankRepository;
import spring.mvc.service.BankService;

import java.util.List;

@Service
@Transactional
public class BankServiceImpl implements BankService {

    @Autowired
    private BankRepository bankRepository;

    @Override
    public BankEntity addBank(BankEntity bankEntity) {
        BankEntity savedBankEntity = bankRepository.save(bankEntity);

        return savedBankEntity;
    }

    @Override
    public void delete(long id) {
        bankRepository.delete(id);
    }

    @Override
    public BankEntity getByName(String name) {
        return bankRepository.findByName(name);
    }

    @Override
    public BankEntity editBank(BankEntity bankEntity) {
        return bankRepository.saveAndFlush(bankEntity);
    }

    @Override
    public List<BankEntity> getAll() {
        return bankRepository.findAll();
    }
}