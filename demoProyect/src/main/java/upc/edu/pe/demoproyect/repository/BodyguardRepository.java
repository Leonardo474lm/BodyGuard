package upc.edu.pe.demoproyect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import upc.edu.pe.demoproyect.entities.Bodyguard;
import java.util.List;

@Repository
public interface BodyguardRepository extends JpaRepository<Bodyguard,Integer> {
    @Query("SELECT b FROM Bodyguard b WHERE b.specialization.id = :specializationId")
    List<Bodyguard> findBySpecializationId(@Param("specializationId") int specializationId);
    List<Bodyguard> findByDistrict(String address);
    @Query("SELECT AVG(s.review) FROM Services s WHERE s.bodyguards.id = :bodyguardId")
    Integer getAverageReviewByBodyguardId(@Param("bodyguardId") int bodyguardId);
}
