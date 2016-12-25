package net.java.seven.test.db_service.repository;

import net.java.seven.test.models.Credit;
import net.java.seven.test.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@SuppressWarnings("JpaQlInspection")
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Query("select p from Payment p where p.creditId=:creditId")
    List<Payment> getAllPaymentByCreditId(@Param("creditId") Long creditId);

}
