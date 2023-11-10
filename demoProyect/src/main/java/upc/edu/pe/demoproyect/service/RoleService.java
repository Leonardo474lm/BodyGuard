package upc.edu.pe.demoproyect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.demoproyect.entities.Role;
import upc.edu.pe.demoproyect.interfaceservice.RoleInterface;
import upc.edu.pe.demoproyect.repository.RoleRepository;

import java.util.List;

@Service
public class RoleService implements RoleInterface {
@Autowired
private RoleRepository roleRepository;
    @Override
    public void insert(Role role) {
roleRepository.save(role);
    }

    @Override
    public List<Role> list() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRolByUserId(int id)
    {
        return  roleRepository.findByUser_Id(id);
    }
}
