package upc.edu.pe.demoproyect.interfaceservice;

import javax.xml.stream.Location;
import java.util.List;

public interface LocationInterface {
    public Location insert(Location location);
    public Location update(Location location);
    public Location delete(int id);
    public List<Location> listLocations();
}
