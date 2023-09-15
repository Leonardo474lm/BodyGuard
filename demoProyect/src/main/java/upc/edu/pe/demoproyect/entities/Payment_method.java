package upc.edu.pe.demoproyect.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "payment_methods")
public class Payment_method {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String methods;

    @OneToMany(mappedBy = "payment_method", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Service> services;
}
