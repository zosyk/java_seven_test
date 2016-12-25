package net.java.seven.test.db_service.repository;

import net.java.seven.test.models.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@SuppressWarnings("JpaQlInspection")
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("select c from Client c")
    Page<Client> findByOffset(Pageable Pageable);

    @Query("select c.id from Client c")
    List<Long> getAllClientId();
}
