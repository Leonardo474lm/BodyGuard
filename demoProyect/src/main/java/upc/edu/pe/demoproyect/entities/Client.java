package upc.edu.pe.demoproyect.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "clients")
public class Client {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "User_id", referencedColumnName = "id")
    private User user;

}
