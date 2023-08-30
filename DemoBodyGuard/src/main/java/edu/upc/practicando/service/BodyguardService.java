package edu.upc.practicando.service;

import edu.upc.practicando.entities.Bodyguard;
import edu.upc.practicando.entities.Especialty;
import edu.upc.practicando.interfaceservice.BodyguardInterface;
import edu.upc.practicando.repository.BodyguardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BodyguardService implements BodyguardInterface {

    @Autowired
    private BodyguardRepository br;
    @Override
    public Bodyguard register(Bodyguard bodyguard) {
        return br.save(bodyguard);
    }

    @Override
    public List<Bodyguard> list() {
        return br.findAll();
    }

    @Override
    public Bodyguard find(int id) {
        return br.findById(id).get();
    }

    @Override
    public void delete(int id) {
         br.deleteById(id);
    }

    public List<Bodyguard> getBodyguardsByEspecialty(int specialty) {
        return br.findByEspecialty(specialty);
    }
}
