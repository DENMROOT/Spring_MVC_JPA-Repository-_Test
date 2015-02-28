package spring.mvc.service;

import spring.mvc.entity.Worker;

import java.util.List;

/**
 * Created by Денис on 28.02.2015.
 */
public interface WorkerService {
    Worker addWorker(Worker worker);
    void delete(long id);
    Worker getByName(String lastname);
    Worker editWorker(Worker worker);
    List<Worker> getAll();
}
