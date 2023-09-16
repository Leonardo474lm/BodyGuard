package upc.edu.pe.demoproyect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upc.edu.pe.demoproyect.entities.Bodyguard;

@Repository
public interface BodyguardRepository extends JpaRepository<Bodyguard,Integer> {
}
