package upc.edu.pe.demoproyect.interfaceservice;
import upc.edu.pe.demoproyect.entities.Services;
import java.time.LocalDate;
import java.util.List;

public interface ServiceInterface {

    public List<Services> findServices();
    public Services registerServices(Services services);

    public Services updateServices(Services services) throws Exception;

    public Services deleteServices(int id) throws Exception;

    public Services findByStartdate (LocalDate fecha);

  //  Integer obtenerSumaDePuntajes();
}
