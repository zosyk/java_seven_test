package net.java.seven.test.db_service.repository;

import net.java.seven.test.models.Credit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@SuppressWarnings("JpaQlInspection")
public interface CreditRepository extends JpaRepository<Credit, Long> {

    @Query("select c from Credit c where c.clientId=:clientId")
    List<Credit> getAllCreditByClientId(@Param("clientId") Long clientId);

    @Query("select c.id from Credit c where c.clientId=:clientId and c.closeDate >=:currentTime")
    List<Long> getListOpenedLine(@Param("clientId") Long clientId, @Param("currentTime") Long currentTime);

    @Query("select c.id from Credit c where c.clientId=:clientId and c.closeDate <:currentTime")
    List<Long> getListClosedLine(@Param("clientId") Long clientId, @Param("currentTime") Long currentTime);
}
