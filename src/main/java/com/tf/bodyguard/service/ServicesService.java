package com.tf.bodyguard.service;

import com.tf.bodyguard.entities.Services;

import java.time.LocalDate;
import java.util.List;

public interface ServicesService {

    public List<Services> findServices();
    public Services registerServices(Services services) throws Exception;

    public Services updateServices(Services services) throws Exception;

    public Services deleteServices(Long id) throws Exception;

    public Services findByStartdate (LocalDate fecha);

    Integer obtenerSumaDePuntajes();
}
