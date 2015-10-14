package spring.mvc.service;

import spring.mvc.entity.WorkerEntity;

import java.util.List;

/**
 * Created by Денис on 28.02.2015.
 */
public interface WorkerService {
    WorkerEntity addWorker(WorkerEntity workerEntity);
    void delete(long id);
    WorkerEntity getByName(String lastname);
    WorkerEntity editWorker(WorkerEntity workerEntity);
    List<WorkerEntity> getAll();
}
