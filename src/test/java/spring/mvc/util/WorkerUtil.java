package spring.mvc.util;

import spring.mvc.entity.Bank;
import spring.mvc.entity.Client;
import spring.mvc.entity.Worker;
import spring.mvc.entity.enums.WorkerStatus;

/**
 * Created by Денис on 28.02.2015.
 */
public class WorkerUtil {

    public static Worker createWorker(String firstName, String lastName, WorkerStatus status, String phoneNumber, Bank bank) {
        Worker worker = new Worker();
        worker.setFirstName(firstName);
        worker.setLastName(lastName);
        worker.setStatus(status);
        worker.setPhoneNumber(phoneNumber);
        worker.setBank(bank);

        return worker;
    }

}