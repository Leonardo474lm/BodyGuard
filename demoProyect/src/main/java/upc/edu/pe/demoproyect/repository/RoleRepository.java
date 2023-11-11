package upc.edu.pe.demoproyect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import upc.edu.pe.demoproyect.entities.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    @Query("SELECT r FROM Role r WHERE r.user.id = :id")
    public Role findByUser_Id(int id);
}
