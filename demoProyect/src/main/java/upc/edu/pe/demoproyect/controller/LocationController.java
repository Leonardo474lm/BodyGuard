package upc.edu.pe.demoproyect.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import upc.edu.pe.demoproyect.dto.LocationDTO;
import upc.edu.pe.demoproyect.entities.Location;
import upc.edu.pe.demoproyect.service.LocationService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/locationController")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @PostMapping("/location")
    public ResponseEntity<LocationDTO> insert(@RequestBody LocationDTO locationDTO)
    {
        Location location;
        LocationDTO lDTO;
        try
        {
            location = convertToEntity(locationDTO);
            location = locationService.insert(location);
            lDTO = convertToDTO(location);

        }
        catch  (Exception e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se pudo registrar");

        }

        return new ResponseEntity<LocationDTO>(lDTO,HttpStatus.OK);

    }
    @PutMapping("/location")
    public  ResponseEntity<LocationDTO> update(@RequestBody LocationDTO locationDTO)
    {
        Location location;
        LocationDTO lDTO;

        try{
            location = convertToEntity(locationDTO);
            location = locationService.update(location);
            lDTO = convertToDTO(location);

        }
        catch ( Exception e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontro el usuario");
        }
        return new ResponseEntity<LocationDTO>(lDTO, HttpStatus.OK);
    }
    @DeleteMapping("/location/{id}")
    public ResponseEntity<LocationDTO> delete(@PathVariable(value = "id") int id)
    {
        Location location ;
        LocationDTO locationDTO;
        try {
            location = locationService.delete(id);
            locationDTO = convertToDTO(location);
        }
        catch(Exception e)
        {
            throw new  ResponseStatusException(HttpStatus.NOT_FOUND,"No se pudo eliminar");
        }
        return new ResponseEntity<LocationDTO>(locationDTO,HttpStatus.OK);
    }
    @GetMapping("/locations")
    public List<Location> listLocations(){
        return locationService.listLocations();
    }




    private Location convertToEntity(LocationDTO locationDTO)
    {
        ModelMapper modelMapper = new ModelMapper();
        Location entity = modelMapper.map(locationDTO,Location.class);
        return entity;
    }
    private LocationDTO convertToDTO(Location location)
    {
        ModelMapper modelMapper = new ModelMapper();
        LocationDTO dto = modelMapper.map(location,LocationDTO.class);
        return dto;
    }
    private List<LocationDTO> convertListToDTO(List<Location> listLocations)
    {
        return listLocations.stream().map(this::convertToDTO).collect(Collectors.toList());
    }







}
