package upc.edu.pe.demoproyect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import upc.edu.pe.demoproyect.entities.Location;


@Repository
public interface LocationRepository extends JpaRepository<Location,Integer> {
    @Query("select lo from Location lo where lo.city=?1")
    Location findByCity(String city);



}
