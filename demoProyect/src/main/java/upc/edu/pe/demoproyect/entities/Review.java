package upc.edu.pe.demoproyect.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "reviews")
public class Review {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private int bodyguard_grade;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bodyguard_id", referencedColumnName = "id")
    private Bodyguard bodyguard;
}
