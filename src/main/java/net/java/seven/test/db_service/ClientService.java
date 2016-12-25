package net.java.seven.test.db_service;


import net.java.seven.test.models.Client;

import java.util.List;

public interface ClientService {

    Client getByID(final long id);

    List<Client> getClientByOffset(final int offset, final int limit);

    List<Long> getAllClientId();

    void save(Client client);
}
