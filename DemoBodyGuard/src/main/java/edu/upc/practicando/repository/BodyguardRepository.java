package edu.upc.practicando.repository;
import edu.upc.practicando.entities.Bodyguard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BodyguardRepository extends JpaRepository<Bodyguard, Integer> {
    @Query("SELECT b FROM Bodyguard b WHERE b.especialty.Id = :especialty")
    List<Bodyguard> findByEspecialty(@Param("especialty") int specialty);


}
