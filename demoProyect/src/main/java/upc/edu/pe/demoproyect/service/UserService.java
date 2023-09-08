package upc.edu.pe.demoproyect.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import upc.edu.pe.demoproyect.entities.User;
import upc.edu.pe.demoproyect.interfaceservice.UserInterface;
import upc.edu.pe.demoproyect.repository.UserRepository;

import java.util.List;

@Service
public class UserService implements UserInterface {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User Insert(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> List() {
        return userRepository.findAll();
    }

    @Override
    public User Delete(int id) throws Exception {
        User user = userRepository.findById(id).
                orElseThrow(() -> new Exception("no se encontro entidad gg"));
        userRepository.delete(user);
        return user;
    }


    @Override
    public User Find_id(int id) {
        return userRepository.findById(id).get();
    }

    public User Update(User user) throws Exception {
        userRepository.findById(user.getId()).
                orElseThrow(() -> new Exception("No se encontró entidad"));
        return userRepository.save(user);
    }

}
