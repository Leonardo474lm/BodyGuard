package upc.edu.pe.demoproyect.interfaceservice;

import upc.edu.pe.demoproyect.entities.Bodyguard;
import upc.edu.pe.demoproyect.entities.Client;

import java.util.List;

public interface BodyguarInterface {
    public Bodyguard Insert(Bodyguard bodyguard)throws Exception;

    public List<Bodyguard> List();

    public Bodyguard Update(Bodyguard bodyguard) throws Exception;

    public Bodyguard Find_id(int id);
}
