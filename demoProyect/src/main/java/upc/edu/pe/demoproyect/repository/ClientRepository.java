package upc.edu.pe.demoproyect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import upc.edu.pe.demoproyect.entities.Client;
import upc.edu.pe.demoproyect.entities.Services;
import upc.edu.pe.demoproyect.entities.User;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
  //US-07 lista de servicios segun el cliente

    public Client findClientByUserId(int id);

}
