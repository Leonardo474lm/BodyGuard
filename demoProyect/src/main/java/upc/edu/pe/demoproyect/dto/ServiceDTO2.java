package upc.edu.pe.demoproyect.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import upc.edu.pe.demoproyect.entities.Bodyguard;
import upc.edu.pe.demoproyect.entities.Client;
import upc.edu.pe.demoproyect.entities.Payment;

import java.time.LocalDate;

public class ServiceDTO2 {
    private int id;

    private LocalDate date;

    private int hours_start;

    private int hours;

    private String location;

    private Boolean st_aceptar;

    private Boolean st_pagado;

    private Boolean st_anulado;
    @JsonIgnore
    private Client clients;
    @JsonIgnore
    private Bodyguard bodyguards;
    @JsonIgnore
    private Payment payment_method;
    private transient int star;


}
