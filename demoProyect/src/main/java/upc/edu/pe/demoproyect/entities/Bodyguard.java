package upc.edu.pe.demoproyect.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "bodyguards")
public class Bodyguard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "price_per_hour")
    private BigDecimal price_per_hour;
    private Boolean st_activo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "User_id", referencedColumnName = "id")
    private User user;


    @ManyToMany
    Set<Specialization> likedCourses;

}
