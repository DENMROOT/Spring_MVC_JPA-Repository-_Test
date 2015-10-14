package spring.mvc.service.Impl;

/**
 * Created by Денис on 28.02.2015.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.mvc.entity.WorkerEntity;
import spring.mvc.repository.WorkerRepository;
import spring.mvc.service.WorkerService;

import java.util.List;

@Service
@Transactional
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    private WorkerRepository WorkerRepository;

    @Override
    public WorkerEntity addWorker(WorkerEntity WorkerEntity) {
        WorkerEntity savedWorkerEntity = WorkerRepository.save(WorkerEntity);

        return savedWorkerEntity;
    }

    @Override
    public void delete(long id) {
        WorkerRepository.delete(id);
    }

    @Override
    public WorkerEntity getByName(String lastname) {
        return WorkerRepository.findByName(lastname);
    }

    @Override
    public WorkerEntity editWorker(WorkerEntity WorkerEntity) {
        return WorkerRepository.saveAndFlush(WorkerEntity);
    }

    @Override
    public List<WorkerEntity> getAll() {
        return WorkerRepository.findAll();
    }
}