package com.tf.bodyguard.controller;

import com.tf.bodyguard.dtos.ServicesDTO;
import com.tf.bodyguard.entities.Services;

import com.tf.bodyguard.service.ServicesService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/services")
public class ServicesController {

    @Autowired
    private ServicesService servicesService;

    @GetMapping("/find")
    public ResponseEntity<List<ServicesDTO>> findServices()
    {
        List<Services> list;
        List<ServicesDTO> listdto = null;
        try {
            list = servicesService.findServices();
            listdto = convertToListDto(list);
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lista no disponible");
        }
        return new ResponseEntity<>(listdto,HttpStatus.OK);

    }

    @GetMapping("/findbyfecha/{date}")
    public ResponseEntity<ServicesDTO> findByStarDate(@PathVariable(value = "date")LocalDate date)
    {
        Services services;
        ServicesDTO servicesDTO = null;
        try {
            services = servicesService.findByStartdate(date);
            servicesDTO = convertToDto(services);
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lista no disponible");
        }
        return new ResponseEntity<>(servicesDTO,HttpStatus.OK);

    }

    /*@GetMapping("/calcuTimes")
    public ResponseEntity<ServicesDTO> calcuTiempos()
    {
        /*Services services;
        ServicesDTO servicesDTO = null;
        try {
            services = servicesService.findByStartdate(date);
            servicesDTO = convertToDto(services);
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lista no disponible");
        }
        return new ResponseEntity<>(servicesDTO,HttpStatus.OK);
        return new ResponseEntity<>(servicesService.obtenerSumaDePuntajes(),HttpStatus.OK);
    }*/
    @GetMapping("/suma")
    public Integer sumarPuntajes() {
        return servicesService.obtenerSumaDePuntajes();
    }

    @PostMapping("/register")
    ResponseEntity<ServicesDTO> registerServices(@RequestBody ServicesDTO servicesDTO){
        Services services;
        ServicesDTO dto;
        try {
            services = convertToEntity(servicesDTO);
            services = servicesService.registerServices(services);
            dto = convertToDto(services);
        }
        catch(Exception e){
            //logeas el error
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se ha podido registrar");
        }
        return new ResponseEntity<ServicesDTO>(dto,HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Services> updateServices(@RequestBody Services services){
        Services services1;
        try {
            services1 = servicesService.updateServices(services);
        }catch(Exception e){
            //aqui se graba en el log el error tecnico que lo tiene e
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se puede actualizar");
        }
        return new ResponseEntity<Services>(services1, HttpStatus.OK);
    }

    @DeleteMapping("/author/{id}")
    Services delete(@PathVariable(value = "id") Long id){
        Services services;
        try{
            services = servicesService.deleteServices(id);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se puede eliminar");
        }
        return services ;
    }

    private Services convertToEntity(ServicesDTO servicesDTO){
        ModelMapper modelMapper = new ModelMapper();
        Services post = modelMapper.map(servicesDTO, Services.class);
        return post;
    }
    private ServicesDTO convertToDto(Services services){
        ModelMapper modelMapper = new ModelMapper();
        ServicesDTO servicesDTO = modelMapper.map(services,ServicesDTO.class);
        return servicesDTO;
    }
    private List<ServicesDTO> convertToListDto(List<Services> list){
        return list.stream().map(this::convertToDto).collect(Collectors.toList());
    }

}
