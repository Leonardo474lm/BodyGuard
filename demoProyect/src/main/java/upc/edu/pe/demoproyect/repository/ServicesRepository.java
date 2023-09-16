package upc.edu.pe.demoproyect.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import upc.edu.pe.demoproyect.entities.Services;

import java.time.LocalDate;



@Repository
public interface ServicesRepository extends JpaRepository<Services, Integer> {

    public Services findByDate (LocalDate fecha);

  //  @Query("SELECT SUM(s.time) FROM Service s")
 //   Integer sumarTiempos();

}
