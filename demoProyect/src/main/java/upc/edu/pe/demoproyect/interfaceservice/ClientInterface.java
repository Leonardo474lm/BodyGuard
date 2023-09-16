package upc.edu.pe.demoproyect.interfaceservice;

import upc.edu.pe.demoproyect.entities.Client;

import java.util.List;

public interface ClientInterface {
    public Client Insert(Client client)throws Exception;

    public List<Client> List();

    public Client Update(Client client) throws Exception;

    public Client Find_id(int id);
}
