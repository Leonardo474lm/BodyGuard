package upc.edu.pe.demoproyect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.demoproyect.entities.Location;
import upc.edu.pe.demoproyect.interfaceservice.LocationInterface;
import upc.edu.pe.demoproyect.repository.LocationRepository;

import java.util.List;


@Service
public class LocationService implements LocationInterface {

    @Autowired
    private LocationRepository locationRepository;
    @Override
    public Location insert(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public Location update(Location location) throws Exception {
        locationRepository.findById(location.getId()).orElseThrow(()->new Exception("El location no esta registrado"));
        return locationRepository.save(location);
    }

    @Override
    public Location delete(int id) throws Exception {
        Location location = locationRepository.findById(id).orElseThrow(()->new Exception("El location no esta registrado"));
        locationRepository.delete(location);
        return location;
    }

    @Override
    public List<Location> listLocations() {
        return locationRepository.findAll();
    }

}
