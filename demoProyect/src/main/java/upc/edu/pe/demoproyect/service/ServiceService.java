package upc.edu.pe.demoproyect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.demoproyect.entities.Services;
import upc.edu.pe.demoproyect.interfaceservice.ServiceInterface;
import upc.edu.pe.demoproyect.repository.ServicesRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServiceService implements ServiceInterface {
    @Autowired
    ServicesRepository servicesRepository;

    public List<Services> findServices() {
        return servicesRepository.findAll();
    }

    public Services registerServices(Services services) throws Exception {

        return servicesRepository.save(services);
    }

    public Services updateServices(Services services) throws Exception {
        servicesRepository.findById(services.getId()).
                orElseThrow(() -> new Exception("No se encontró entidad"));
        return servicesRepository.save(services);
    }


    public Services deleteServices(int id) throws Exception {
        Services services = servicesRepository.findById(id).
                orElseThrow(() -> new Exception("No se encontró entidad"));
        servicesRepository.delete(services);
        return services;
    }

    public Services findByStartdate(LocalDate fecha) {
        return servicesRepository.findByDate(fecha);

    }
;


/*        public Services findByStartdate (LocalDate fecha){
        return  servicesRepository.findByStartdate(fecha);
    };

    public Integer obtenerSumaDePuntajes() {
        return servicesRepository.sumarTiempos();
    }
    }*/
}
