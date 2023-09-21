package upc.edu.pe.demoproyect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upc.edu.pe.demoproyect.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {
}
