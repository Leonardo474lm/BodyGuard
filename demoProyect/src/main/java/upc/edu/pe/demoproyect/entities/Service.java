package upc.edu.pe.demoproyect.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private LocalDate date;
    private Time hours_start;
    private int hours;
    private String location_encuentro;
    //activo (cuando el cliente pago) o inactivo (cuando el cliente aun no pago)
    private Boolean st_pagado;
    //el cliente anulo el servicio
    private Boolean st_anulado;
    private int review;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client clients;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bodyguard_id")
    private Bodyguard bodyguards;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    private Payment_method payment_method;

}
