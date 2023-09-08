package upc.edu.pe.demoproyect.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;

@Data
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

    public User() {
    }

    public User(int id, String dni, String name, String lastname, String email, int age, String gender, String phone, String password, String id_City, String id_User) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.password = password;
        this.id_City = id_City;

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId_City(String id_City) {
        this.id_City = id_City;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", id_City='" + id_City + '\'' +

                '}';
    }
}
