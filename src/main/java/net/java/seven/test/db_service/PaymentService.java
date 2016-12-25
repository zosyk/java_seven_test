package net.java.seven.test.db_service;


import net.java.seven.test.models.Credit;
import net.java.seven.test.models.Payment;

import java.util.List;

public interface PaymentService {

    Payment getByID(long id);

    List<Payment> getAllPaymentByCreditId(Long creditId);

    void save(Payment payment);
}
