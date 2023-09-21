package upc.edu.pe.demoproyect.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import upc.edu.pe.demoproyect.dto.ClientDTO;
import upc.edu.pe.demoproyect.dto.ServicesDTO;
import upc.edu.pe.demoproyect.entities.Client;
import upc.edu.pe.demoproyect.entities.Services;
import upc.edu.pe.demoproyect.service.ServiceService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/services")
public class ServicesController {
    @Autowired
    private ServiceService servicesService;
    @PostMapping("/insert")
    ResponseEntity<ServicesDTO> registerServices(@RequestBody ServicesDTO servicesDTO) {
        Services services;
        ServicesDTO dto;
        try {
            services = convertToEntity(servicesDTO);
            services = servicesService.registerServices(services);
            dto = convertToDto(services);
        } catch (Exception e) {
            //logeas el error
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se ha podido registrar");
        }
        return new ResponseEntity<ServicesDTO>(dto, HttpStatus.OK);
    }
    @GetMapping("/list")
    public ResponseEntity<List<Services>> List() {
        List<Services> services = null;

        services = servicesService.findServices();
        return new ResponseEntity<List<Services>>(services, HttpStatus.OK);
    }
    @PutMapping("/Update")
    public ResponseEntity<ServicesDTO> updateServices(@RequestBody Services services) {
        Services services1;
        ServicesDTO servicesDTO=null;
        try {
            services1 = servicesService.updateServices(services);
            servicesDTO=convertToDto(services);
        } catch (Exception e) {
            //aqui se graba en el log el error tecnico que lo tiene e
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se puede actualizar");
        }
        return new ResponseEntity<ServicesDTO>(servicesDTO, HttpStatus.OK);
    }

    @DeleteMapping("/Delete/{id}")
    Services delete(@PathVariable(value = "id") int id) {
        Services services;
        try {
            services = servicesService.deleteServices(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se puede eliminar");
        }
        return services;
    }
    @GetMapping("/findbyfecha/{date}")
    public ResponseEntity<ServicesDTO> findByStarDate(@PathVariable(value = "date") LocalDate date) {
        Services services;
        ServicesDTO servicesDTO = null;
        try {
            services = servicesService.findByStartdate(date);
            servicesDTO = convertToDto(services);
        } catch (Exception e) {
            //aqui se graba en el log el error tecnico que lo tiene e
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se puede actualizar");
        }
        return new ResponseEntity<ServicesDTO>(servicesDTO, HttpStatus.OK);
    }

    // Endpoint para obtener los servicios de un cliente por su ID
    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<Services>> getServicesByClientId(@PathVariable int clientId) {
        List<Services> services = servicesService.getServicesByClientId(clientId);
        return new ResponseEntity<>(services, HttpStatus.OK);
    }
    @GetMapping("/bodiguard/{bodyid}")
    public ResponseEntity<List<Services>> findServicesByBodyguardID(@PathVariable int bodyid) {
        List<Services> services = servicesService.getServicesByClientId(bodyid);
        return new ResponseEntity<>(services, HttpStatus.OK);
    }


    @GetMapping("HourTotal/{bodyID}")
    public ResponseEntity<Integer> getTotalHoursWorkedForBodyguard(@PathVariable int bodyID) {
        int totalhora = servicesService.getTotalHoursWorkedForBodyguard(bodyID);
        return new ResponseEntity<>(totalhora, HttpStatus.OK);
    }

    @GetMapping("Pagototal/{bodyguardId}")
    public float getTotalEarningsForBodyguard(@PathVariable Integer bodyguardId) {
        // Utiliza el método del repositorio para calcular el monto total ganado
        return servicesService.getTotalEarningsForBodyguard(bodyguardId);
    }

    @GetMapping("/countclientesByBodyguard/{bodyguardId}")
    public Long countClientsServedByBodyguard(@PathVariable Integer bodyguardId) {
        // Utiliza el método del repositorio para contar la cantidad de clientes atendidos
        return servicesService.countClientsServedByBodyguard(bodyguardId);
    }


    //_____________________________________________________________________________||||||
    private Services convertToEntity(ServicesDTO servicesDTO) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(servicesDTO, Services.class);
    }

    private ServicesDTO convertToDto(Services services) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(services, ServicesDTO.class);
    }

    private List<ServicesDTO> convertToListDto(List<Services> list) {
        return list.stream().map(this::convertToDto).collect(Collectors.toList());
    }

}
