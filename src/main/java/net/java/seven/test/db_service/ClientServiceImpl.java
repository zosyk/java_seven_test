package net.java.seven.test.db_service;


import net.java.seven.test.db_service.repository.ClientRepository;
import net.java.seven.test.models.Client;
import net.java.seven.test.utils.CustomPageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository repository;

    @Override
    public Client getByID(long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Client> getClientByOffset(int offset, int limit) {
        return repository.findByOffset(new CustomPageable(offset, limit)).getContent();
    }

    @Override
    public List<Long> getAllClientId() {
        return repository.getAllClientId();
    }

    @Override
    public void save(Client client) {
        repository.saveAndFlush(client);
    }
}
