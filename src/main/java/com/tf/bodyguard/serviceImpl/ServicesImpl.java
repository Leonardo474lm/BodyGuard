package com.tf.bodyguard.serviceImpl;

import com.tf.bodyguard.entities.Services;
import com.tf.bodyguard.repositorys.ServicesRepository;
import com.tf.bodyguard.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServicesImpl implements ServicesService {
    @Autowired
    ServicesRepository servicesRepository;
    public List<Services> findServices() {return servicesRepository.findAll();}
    public Services registerServices(Services services) throws Exception {

        return  servicesRepository.save(services);}

    public Services updateServices(Services services) throws Exception {
        servicesRepository.findById(services.getId()).
                orElseThrow(()-> new Exception("No se encontró entidad"));
        return servicesRepository.save(services);
    }
    public Services deleteServices(Long id) throws Exception{
        Services services = servicesRepository.findById(id).
                orElseThrow(()->new Exception("No se encontró entidad"));
        servicesRepository.delete(services);
        return services;
    }
    public Services findByStartdate (LocalDate fecha){
        return  servicesRepository.findByStartdate(fecha);
    };

    public Integer obtenerSumaDePuntajes() {
        return servicesRepository.sumarTiempos();
    }

}
