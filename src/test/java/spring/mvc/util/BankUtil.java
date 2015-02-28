package spring.mvc.util;

import spring.mvc.entity.Bank;

/**
 * Created by Денис on 28.02.2015.
 */
public class BankUtil {

    public static Bank createBank(String name) {
        Bank bank = new Bank();
        bank.setName(name);

        return bank;
    }

}