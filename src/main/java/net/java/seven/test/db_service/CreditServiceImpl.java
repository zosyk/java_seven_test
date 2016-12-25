package net.java.seven.test.db_service;


import net.java.seven.test.db_service.repository.CreditRepository;
import net.java.seven.test.models.Credit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditServiceImpl implements CreditService {

    @Autowired
    CreditRepository repository;

    @Override
    public Credit getByID(long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Credit> getAllCreditByClientId(Long clientId) {
        return repository.getAllCreditByClientId(clientId);
    }

    @Override
    public List<Long> getListOpenedLine(Long clientId, Long currentTime) {
        return repository.getListOpenedLine(clientId, currentTime);
    }

    @Override
    public List<Long> getListClosedLine(Long clientId, Long currentTime) {
        return repository.getListClosedLine(clientId, currentTime);
    }

    @Override
    public void save(Credit credit) {
        repository.saveAndFlush(credit);
    }
}
