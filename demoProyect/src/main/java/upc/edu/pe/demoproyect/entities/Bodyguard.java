package upc.edu.pe.demoproyect.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bodyguards")
public class Bodyguard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "price_per_hour")
    private float price_per_hour;
    @Column(name = "st_activo")
    private Boolean st_activo;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "User_id", referencedColumnName = "id")
    private User user;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "specializations", referencedColumnName = "id")
    private Specialization specialization;
    @Column(name = "district")
    private String district;








/*    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "Bodyguards_specialization",
            joinColumns = @JoinColumn(name = "bodyguard_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "specialization_id",referencedColumnName = "id"))
    private List<Specialization> specialization;

*/
}