package upc.edu.pe.demoproyect.entities;

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
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;
    private int hours_start;
    private int hours_end;
    private String typeservice;
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
