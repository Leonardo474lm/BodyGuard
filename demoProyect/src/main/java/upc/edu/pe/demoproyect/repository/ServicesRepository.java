package upc.edu.pe.demoproyect.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import upc.edu.pe.demoproyect.entities.Services;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface ServicesRepository extends JpaRepository<Services, Integer> {

    public Services findByDate (LocalDate fecha);

  //  @Query("SELECT SUM(s.time) FROM Service s")
 //   Integer sumarTiempos();


    @Query("SELECT s FROM Services s WHERE s.clients.user.id = :userId")
    List<Services> findServic(int userId);
    @Query("SELECT s FROM Services s WHERE s.bodyguards.user.id = :bodyguardid")
    List<Services> findServicesByBodyguarID(int bodyguardid);

    @Query("SELECT SUM(s.hours) FROM Services s WHERE s.bodyguards.id = :bodyguardId")
    Integer calculateTotalHoursWorked(@Param("bodyguardId") Integer bodyguardId);

    @Query("SELECT SUM(s.hours * b.price_per_hour) " +
            "FROM Services s " +
            "JOIN s.bodyguards b " +
            "WHERE b.id = :bodyguardId")
    float calculateTotalEarningsForBodyguard(@Param("bodyguardId") Integer bodyguardId);
    @Query("SELECT COUNT(DISTINCT s.clients) " +
            "FROM Services s " +
            "WHERE s.bodyguards.id = :bodyguardId")

    Long countDistinctClientsForBodyguard(@Param("bodyguardId") Integer bodyguardId);







}
