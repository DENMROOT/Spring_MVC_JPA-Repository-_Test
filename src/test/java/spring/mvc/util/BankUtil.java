package spring.mvc.util;

import spring.mvc.entity.BankEntity;

/**
 * Created by Денис on 28.02.2015.
 */
public class BankUtil {

    public static BankEntity createBank(String name) {
        BankEntity bankEntity = new BankEntity();
        bankEntity.setName(name);

        return bankEntity;
    }

}