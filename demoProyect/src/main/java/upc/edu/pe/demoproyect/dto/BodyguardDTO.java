package upc.edu.pe.demoproyect.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import upc.edu.pe.demoproyect.entities.Specialization;
import upc.edu.pe.demoproyect.entities.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
@Data
@NoArgsConstructor
public class BodyguardDTO {
    private int id;
    private float price_per_hour;
    private Boolean st_activo;
    private User user;
    private Specialization specialization;

    private String district;
}
