package upc.edu.pe.demoproyect.interfaceservice;

import org.apache.tomcat.util.buf.UDecoder;
import upc.edu.pe.demoproyect.entities.User;

import java.util.List;

public interface UserInterface {
    public void Insert(User user);

    public List<User> List();

    public User Delete(int id) throws Exception;

    public User Update(User user) throws Exception;

    public User Find_id(int id);
}
