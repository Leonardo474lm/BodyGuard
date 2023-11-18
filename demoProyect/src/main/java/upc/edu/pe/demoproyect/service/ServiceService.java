package upc.edu.pe.demoproyect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import upc.edu.pe.demoproyect.entities.Services;
import upc.edu.pe.demoproyect.interfaceservice.ServiceInterface;
import upc.edu.pe.demoproyect.repository.ServicesRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    public Integer getTotalHoursWorkedForBodyguard(int bodyguardId) {
        Integer total =  servicesRepository.calculateTotalHoursWorked(bodyguardId, java.time.LocalDate.now());
        return total !=null? total : 0;
    }


    public float getTotalEarningsForBodyguard(int bodyguardId) {
       return  servicesRepository.calculateTotalEarningsForBodyguard(bodyguardId,java.time.LocalDate.now());
    }

    //solo calcula la cantidad de clientes que ha atendido y no la cantidad de servicios atendidos
    public Long countClientsServedByBodyguard(Integer bodyguardId) {
        Long count= servicesRepository.countDistinctClientsForBodyguard(bodyguardId,java.time.LocalDate.now());
        return count !=null? count : 0;
    }
    public List<Services> listToBodyguard(int bodyId ){
        return servicesRepository.listToBodyguard(bodyId);
    }

    @Override
    public Float getTotalGastosByClient(int id) {
        Float gasto = servicesRepository.getTotalGastosByClient(id,java.time.LocalDate.now());
        return  gasto !=null ? gasto : (float)0;
    }

    @Override
    public Integer getTotalServByClient(int clientId) {
        Integer aux = servicesRepository.getTotalServByClient(clientId,java.time.LocalDate.now());
        return  aux !=null ? aux : 0;
    }

    @Override
    public List<Services> clienthistory(int clientId) {
        List<Services> list1 = servicesRepository.clienthistory(clientId,java.time.LocalDate.now());
        for (Services serv: list1 )
        {
            serv.getBodyguards().setStar(getAverageReviewByBodyguardId(serv.getBodyguards().getId()));
        }
        return list1;
    }

    @Override
    public List<Services> clientServices(int clientId) {
        List<Services> list1 = servicesRepository.clientServices(clientId,java.time.LocalDate.now());
        return list1;
    }

    @Override
    public List<Services> servicesAnuladoIsFalse() {
        return servicesRepository.findAllBySt_anuladoIsFalse();
    }

    public Integer getAverageReviewByBodyguardId(int id) {
        LocalDate currentDate = java.time.LocalDate.now();
        Integer averageReview = servicesRepository.getAverageReviewByBodyguardId(id,currentDate);
        return averageReview != null ? averageReview : 0;

    }












/*        public Services findByStartdate (LocalDate fecha){
        return  servicesRepository.findByStartdate(fecha);
    };

    public Integer obtenerSumaDePuntajes() {
        return servicesRepository.sumarTiempos();
    }
    }*/
}
