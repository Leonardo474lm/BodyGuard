package upc.edu.pe.demoproyect.interfaceservice;

import upc.edu.pe.demoproyect.entities.Bodyguard;


import java.util.List;

public interface BodyguarInterface {
    public Bodyguard Insert(Bodyguard bodyguard)throws Exception;

    public List<Bodyguard> List();

    public Bodyguard Update(Bodyguard bodyguard) throws Exception;


}
