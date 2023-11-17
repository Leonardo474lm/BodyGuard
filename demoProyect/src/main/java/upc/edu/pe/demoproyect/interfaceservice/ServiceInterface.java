package upc.edu.pe.demoproyect.interfaceservice;
import upc.edu.pe.demoproyect.entities.Payment;
import upc.edu.pe.demoproyect.entities.Services;
import upc.edu.pe.demoproyect.entities.Specialization;

import java.time.LocalDate;
import java.util.List;

public interface ServiceInterface {

    public List<Services> findServices();
    public Services registerServices(Services services);

    public Services updateServices(Services services) throws Exception;

    public Services deleteServices(int id) throws Exception;

    public Services findByStartdate (LocalDate fecha);
    public Services listById(int id) throws Exception;

    public List<Services> listToBodyguard(int id);

    public Float getTotalGastosByClient(int id);

    public Integer getTotalServByClient(int clientId);
    public List<Services> clienthistory(int clientId);

    public List<Services> clientServices(int clientId);

  //  Integer obtenerSumaDePuntajes();
}
