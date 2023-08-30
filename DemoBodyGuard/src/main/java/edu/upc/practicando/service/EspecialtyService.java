package edu.upc.practicando.service;

import edu.upc.practicando.entities.Especialty;
import edu.upc.practicando.interfaceservice.EspecialtyInterface;
import edu.upc.practicando.repository.EspecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialtyService implements EspecialtyInterface {
    @Autowired
    private EspecialtyRepository er;

    @Override
    public Especialty generate(Especialty especialty) {
        return er.save(especialty);
    }

    @Override
    public List<Especialty> list() {
        return er.findAll();
    }

    @Override
    public Especialty find(int id) {
        return er.findById(id).get();
    }

    @Override
    public void delete(int id) {
        er.deleteById(id)   ;
    }


}
