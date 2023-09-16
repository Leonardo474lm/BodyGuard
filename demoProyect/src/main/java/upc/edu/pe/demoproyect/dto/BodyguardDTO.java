package upc.edu.pe.demoproyect.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import upc.edu.pe.demoproyect.entities.Specialization;
import upc.edu.pe.demoproyect.entities.User;

import java.math.BigDecimal;
import java.util.Set;
@Data
@NoArgsConstructor
public class BodyguardDTO {
    private int Id;
    private BigDecimal price_per_hour;
    private Boolean st_activo;
    private User user;


}
