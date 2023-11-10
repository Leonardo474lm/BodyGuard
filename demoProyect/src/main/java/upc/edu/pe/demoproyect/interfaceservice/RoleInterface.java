package upc.edu.pe.demoproyect.interfaceservice;

import upc.edu.pe.demoproyect.entities.Role;

import java.util.List;

public interface RoleInterface {
    public void insert(Role role);

    List<Role> list();
    public Role getRolByUserId(int id);
}
