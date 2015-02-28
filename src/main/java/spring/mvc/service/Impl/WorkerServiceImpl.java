package spring.mvc.service.Impl;

/**
 * Created by Денис on 28.02.2015.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.mvc.entity.Worker;
import spring.mvc.repository.WorkerRepository;
import spring.mvc.service.WorkerService;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    private WorkerRepository WorkerRepository;

    @Override
    public Worker addWorker(Worker Worker) {
        Worker savedWorker = WorkerRepository.saveAndFlush(Worker);

        return savedWorker;
    }

    @Override
    public void delete(long id) {
        WorkerRepository.delete(id);
    }

    @Override
    public Worker getByName(String lastname) {
        return WorkerRepository.findByName(lastname);
    }

    @Override
    public Worker editWorker(Worker Worker) {
        return WorkerRepository.saveAndFlush(Worker);
    }

    @Override
    public List<Worker> getAll() {
        return WorkerRepository.findAll();
    }
}