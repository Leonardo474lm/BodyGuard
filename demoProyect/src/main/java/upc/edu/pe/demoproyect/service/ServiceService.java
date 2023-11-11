package upc.edu.pe.demoproyect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import upc.edu.pe.demoproyect.entities.Services;
import upc.edu.pe.demoproyect.interfaceservice.ServiceInterface;
import upc.edu.pe.demoproyect.repository.ServicesRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class ServiceService implements ServiceInterface {
    @Autowired
    ServicesRepository servicesRepository;

    public List<Services> findServices() {
        return servicesRepository.findAll();
    }

    public Services registerServices(Services services) {

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

    @Override
    public Services listById(int id) throws Exception {
        return servicesRepository.findById(id).get();
    }



    public List<Services> getServicesByClientId(int clientId) {
        return servicesRepository.findServic(clientId);
    }
    public List<Services> findServicesByBodyguardID(int body) {
        return servicesRepository.findServicesByBodyguarID(body);
    }
    public int getTotalHoursWorkedForBodyguard(int bodyguardId) {
        return servicesRepository.calculateTotalHoursWorked(bodyguardId);
    }


    public float getTotalEarningsForBodyguard(int bodyguardId) {
        return servicesRepository.calculateTotalEarningsForBodyguard(bodyguardId);
    }

    //solo calcula la cantidad de clientes que ha atendido y no la cantidad de servicios atendidos
    public Long countClientsServedByBodyguard(Integer bodyguardId) {
        return servicesRepository.countDistinctClientsForBodyguard(bodyguardId);
    }
    public List<Services> listToBodyguard(int bodyId ){
        Date currenDate = new Date();
        return servicesRepository.listToBodyguard(currenDate,bodyId);
    }











/*        public Services findByStartdate (LocalDate fecha){
        return  servicesRepository.findByStartdate(fecha);
    };

    public Integer obtenerSumaDePuntajes() {
        return servicesRepository.sumarTiempos();
    }
    }*/
}
