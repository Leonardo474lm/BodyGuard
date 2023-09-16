package upc.edu.pe.demoproyect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upc.edu.pe.demoproyect.entities.Client;
import upc.edu.pe.demoproyect.entities.User;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
  //buscar por dni(user.dni)


}
