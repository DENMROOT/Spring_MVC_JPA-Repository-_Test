package spring.mvc.util;

import spring.mvc.entity.BankEntity;
import spring.mvc.entity.WorkerEntity;
import spring.mvc.entity.enums.WorkerStatus;

/**
 * Created by Денис on 28.02.2015.
 */
public class WorkerUtil {

    public static WorkerEntity createWorker(String firstName, String lastName, WorkerStatus status, String phoneNumber, BankEntity bankEntity) {
        WorkerEntity workerEntity = new WorkerEntity();
        workerEntity.setFirstName(firstName);
        workerEntity.setLastName(lastName);
        workerEntity.setStatus(status);
        workerEntity.setPhoneNumber(phoneNumber);
//        worker.setBank(bank);

        return workerEntity;
    }

}