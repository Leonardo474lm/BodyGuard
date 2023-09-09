package upc.edu.pe.demoproyect.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Country",length = 50, nullable = false)
    private String country;
    @Column (name = "City", length = 50, nullable = false)
    private String City;
    @Column(name = "Address", length = 120, nullable = false)
    private String address;
}
