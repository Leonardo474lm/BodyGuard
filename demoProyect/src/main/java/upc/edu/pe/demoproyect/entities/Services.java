package upc.edu.pe.demoproyect.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "services")
//@JsonIgnoreProperties({"clients", "bodyguards", "payment_method"})


public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "date")
    private LocalDate date;

    @Column(name = "hours_start")
    private int hours_start;

    @Column(name = "hours",nullable = false)
    private int hours;

    @Column(name = "location",nullable = false)
    private String location;

    @Column(name = "st_aceptar",nullable = false)

    private Boolean st_aceptar;
    @Column(name = "st_pagado",nullable = false)
    //activo (cuando el cliente pago) o inactivo (cuando el cliente aun no pago)
    private Boolean st_pagado;

    @Column(name = "st_anulado",nullable = false)
    //el cliente anulo el servicio
    private Boolean st_anulado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id",nullable = false)
    private Client clients;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bodyguard_id",nullable = false)
    private Bodyguard bodyguards;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "payment_id",nullable = false)
    private Payment payment_method;

    @Column(name = "review",nullable = false)
    private int review;


}
