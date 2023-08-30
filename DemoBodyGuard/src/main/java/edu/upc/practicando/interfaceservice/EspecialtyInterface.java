package edu.upc.practicando.interfaceservice;

import edu.upc.practicando.entities.Especialty;

import java.util.List;

public interface EspecialtyInterface {
    public Especialty generate(Especialty especialty);
    List<Especialty> list();
    public Especialty find(int id);
    public void delete(int id);


}
