package net.java.seven.test.db_service;


import net.java.seven.test.db_service.repository.PaymentRepository;
import net.java.seven.test.models.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository repository;

    @Override
    public Payment getByID(long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Payment> getAllPaymentByCreditId(Long creditId) {
        return repository.getAllPaymentByCreditId(creditId);
    }

    @Override
    public void save(Payment payment) {
        repository.saveAndFlush(payment);
    }
}
