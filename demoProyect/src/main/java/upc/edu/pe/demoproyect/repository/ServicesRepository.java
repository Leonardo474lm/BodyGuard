package upc.edu.pe.demoproyect.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import upc.edu.pe.demoproyect.entities.Services;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Repository
public interface ServicesRepository extends JpaRepository<Services, Integer> {

    public Services findByDate(LocalDate fecha);

    //  @Query("SELECT SUM(s.time) FROM Service s")
    //   Integer sumarTiempos();


    @Query("SELECT s FROM Services s WHERE s.clients.user.id = :userId")
    List<Services> findServic(int userId);

    @Query("SELECT s FROM Services s WHERE s.bodyguards.user.id = :bodyguardid")
    List<Services> findServicesByBodyguarID(int bodyguardid);

    @Query("SELECT SUM(s.hours) FROM Services s WHERE s.bodyguards.id = :bodyguardId and s.st_pagado = true and s.st_anulado = false and s.st_aceptar=true and s.date < :currentDate")
    Integer calculateTotalHoursWorked(@Param("bodyguardId") Integer bodyguardId, @Param("currentDate") LocalDate currentDate);

    @Query("SELECT SUM(s.hours * b.price_per_hour) " +
            "FROM Services s " +
            "JOIN s.bodyguards b " +
            "WHERE b.id = :bodyguardId and s.st_pagado = true and s.st_anulado = false and s.st_aceptar=true and s.date < :currentDate")
    float calculateTotalEarningsForBodyguard(@Param("bodyguardId") Integer bodyguardId, @Param("currentDate") LocalDate currentDate);

    @Query("SELECT COUNT( distinct s.clients.id) " +
            "FROM Services s " +
            "WHERE s.bodyguards.id = :bodyguardId and s.st_pagado = true and s.st_anulado = false and s.st_aceptar=true and s.date < :currentDate")
    Long countDistinctClientsForBodyguard(@Param("bodyguardId") Integer bodyguardId, @Param("currentDate") LocalDate currentDate);

    //@Query("select s from Services s where s.st_pagado=true and s.st_anulado=false and s.bodyguards.id=:id")
    //public List<Services> findByStPagadoTrueAndStAnuladoFalseAndDateAfterAndBodyguardIdIs(int id);

    @Query("SELECT s FROM Services s WHERE s.st_pagado = false and s.st_anulado = false and s.st_aceptar=false and s.bodyguards.id=:bodyId")
    List<Services> listToBodyguard(@Param("bodyId") int bodyId);


    @Query("SELECT SUM(s.hours*s.bodyguards.price_per_hour) FROM Services s WHERE s.clients.id = :clientId and s.date < :currentDate and s.st_aceptar=true and s.st_anulado=false and s.st_pagado=true")
    public Float getTotalGastosByClient(@Param("clientId") int clientId, @Param("currentDate") LocalDate currentDat);


    @Query("SELECT COUNT(s.id) FROM Services s WHERE s.clients.id = :clientId and s.date < :currentDate and s.st_aceptar=true and s.st_anulado=false and s.st_pagado=true")
    public Integer getTotalServByClient(@Param("clientId") int clientId, @Param("currentDate") LocalDate currentDat);

    @Query("SELECT AVG(s.review) FROM Services s WHERE s.bodyguards.id = :bodyguardId and s.date < :currentDate")
    Integer getAverageReviewByBodyguardId(@Param("bodyguardId") int bodyguardId, @Param("currentDate") LocalDate currentDate);

    @Query("SELECT s FROM Services s WHERE s.clients.id=:clientId and s.date < :currentDate")
    public List<Services> clienthistory(@Param("clientId") int clientId, @Param("currentDate") LocalDate currentDate);

    @Query("SELECT s FROM Services s WHERE s.clients.id=:clientId and s.date >= :currentDate and s.st_anulado=false ")
    public List<Services> clientServices(@Param("clientId") int clientId, @Param("currentDate") LocalDate currentDate);

    @Query("SELECT s FROM Services s Where s.st_anulado=false")
    public List<Services> findAllBySt_anuladoIsFalse();

    //Integer countByClientsIdAndDateBeforeAndStAceptarIsTrueAndStAnuladoIsFalseAndStPagadoIsTrue(@Param("clientId") int clientId,@Param("currentDate") LocalDate currentDat);
    // Integer countByClientsIdAndDateBeforeAndSt_aceptarIsTrueAndSt_anuladoIsFalseAndSt_pagadoIsTrue( int clientId, LocalDate currentDate);
// ...importaciones y anotaciones de las entidades


    @Query("SELECT SUM(s.bodyguards.price_per_hour *s.hours ) FROM Services s WHERE s.st_pagado = true and s.st_anulado=false  and s.st_aceptar=true  and s.date < :currentDate ")
    public Float getTotalIncome(@Param("currentDate") LocalDate currentDate);

    @Query("SELECT count ( distinct  s.clients.user.id) FROM Services s WHERE s.st_pagado = true and s.st_anulado=false  and s.st_aceptar=true  and s.date < :currentDate ")
    public Integer getclienttotal(@Param("currentDate") LocalDate currentDate);

}
