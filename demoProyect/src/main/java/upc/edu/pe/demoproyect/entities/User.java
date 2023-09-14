package upc.edu.pe.demoproyect.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users", uniqueConstraints = @UniqueConstraint(columnNames = "DNI"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "DNI", unique = true, length = 8)
    private String dni;
    @Column(name = "Name", length = 50)
    private String name;
    @Column(name = "Lastname",  length = 50)
    private String lastname;
    @Column(name = "Email",  length = 50)
    private String email;
    @Column(name = "Age",  length = 50)
    private int age;
    @Column(name = "Gender",  length = 10)
    private String gender;
    @Column(name = "Phone", length = 9)
    private String phone;
    @Column(name = "Password",  length = 20)
    private String password;
    ///esto se tiene que cambiar luego para la implementacion de las tablas respectivas
    @Column(name = "ID_city",  length = 50)
    private String id_City;
}
