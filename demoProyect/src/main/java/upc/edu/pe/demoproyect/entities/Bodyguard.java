package upc.edu.pe.demoproyect.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bodyguards")
public class Bodyguard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "price_per_hour", nullable = false)
    private float price_per_hour;
    @Column(name = "st_activo", nullable = false)
    private Boolean st_activo;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "User_id", referencedColumnName = "id", nullable = false)
    private User user;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "specializations", referencedColumnName = "id", nullable = false)
    private Specialization specialization;
    @Column(name = "district", nullable = false)
    private String district;
    @Column(name = "star")
    //promedio de calificacion (5)
    private transient int star;






/*    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "Bodyguards_specialization",
            joinColumns = @JoinColumn(name = "bodyguard_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "specialization_id",referencedColumnName = "id"))
    private List<Specialization> specialization;

*/
}