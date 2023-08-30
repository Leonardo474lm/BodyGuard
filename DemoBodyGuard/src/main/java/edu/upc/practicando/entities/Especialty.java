package edu.upc.practicando.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Especialty")
public class Especialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int Id;
    @Column(name = "Name")

    private String name;
    @Column(name = "Description")

    private  String description;
    public Especialty(){}

    public Especialty(int id, String name, String description) {
        Id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Especialty{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
