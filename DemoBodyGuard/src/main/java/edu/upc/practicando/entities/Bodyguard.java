package edu.upc.practicando.entities;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.DecimalFormat;

@Entity
@Table(name ="bodyguard")
public class Bodyguard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name = "Gender")
    private String gender;
    @Column(name = "Dni")

    private String dni;
    @Column(name = "Name")

    private String name;
    @Column(name = "Price")
    private float price;
    @ManyToOne
    @JoinColumn(name = "ID_Especialty")
    private Especialty especialty;

    public Bodyguard(int id, String gender, String dni, String name, float price, Especialty especialty) {
        Id = id;
        this.gender = gender;
        this.dni = dni;
        this.name = name;
        this.price = price;
        this.especialty = especialty;
    }

    public Bodyguard() {

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Especialty getEspecialty() {
        return especialty;
    }

    public void setEspecialty(Especialty especialty) {
        this.especialty = especialty;
    }

    @Override
    public String toString() {
        return "Bodyguard{" +
                "Id=" + Id +
                ", gender='" + gender + '\'' +
                ", dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", especialty=" + especialty +
                '}';
    }
}
