package upc.edu.pe.demoproyect.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import upc.edu.pe.demoproyect.entities.User;
@Data
@NoArgsConstructor
public class ClientDTO {

    private int Id;
    private User user;


}
