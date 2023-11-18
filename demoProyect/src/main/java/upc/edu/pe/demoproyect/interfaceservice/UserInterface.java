package upc.edu.pe.demoproyect.interfaceservice;


import upc.edu.pe.demoproyect.entities.User;

import java.util.List;

public interface UserInterface {
    public User Insert(User user);

    public List<User> List();

    public User Delete(int id) throws Exception;

    public User Update(User user) throws Exception;

    public User Find_id(int id);
    public User getByEmail(String email);
}
