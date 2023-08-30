package edu.upc.practicando.interfaceservice;


import edu.upc.practicando.entities.Bodyguard;

import java.util.List;

public interface BodyguardInterface {
    public Bodyguard register(Bodyguard bodyguard);

    List<Bodyguard> list();

    public Bodyguard find(int id);

    public void delete(int id);


}
