package com.tf.bodyguard.repositorys;

import com.tf.bodyguard.entities.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;



@Repository
public interface ServicesRepository extends JpaRepository<Services, Long> {

    public Services findByStartdate (LocalDate fecha);

    @Query("SELECT SUM(s.time) FROM Services s")
    Integer sumarTiempos();

}
