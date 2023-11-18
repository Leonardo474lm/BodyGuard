package upc.edu.pe.demoproyect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upc.edu.pe.demoproyect.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    public User findByEmail(String email);

}
