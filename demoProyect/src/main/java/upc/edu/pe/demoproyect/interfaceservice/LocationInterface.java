package upc.edu.pe.demoproyect.interfaceservice;


import upc.edu.pe.demoproyect.entities.Location;

import java.util.List;

public interface LocationInterface {
    public Location insert(Location location);
    public Location update(Location location) throws Exception;
    public Location delete(int id) throws Exception;
    public List<Location> listLocations();
}
