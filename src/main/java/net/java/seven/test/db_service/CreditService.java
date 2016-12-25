package net.java.seven.test.db_service;


import net.java.seven.test.models.Credit;

import java.util.List;

public interface CreditService {

    Credit getByID(long id);

    List<Credit> getAllCreditByClientId(Long clientId);

    List<Long> getListOpenedLine(Long clientId, Long currentTime);

    List<Long> getListClosedLine(Long clientId, Long currentTime);

    void save(Credit credit);
}
