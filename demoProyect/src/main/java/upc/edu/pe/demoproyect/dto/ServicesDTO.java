package upc.edu.pe.demoproyect.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import upc.edu.pe.demoproyect.entities.Bodyguard;
import upc.edu.pe.demoproyect.entities.Client;
import upc.edu.pe.demoproyect.entities.Payment;

import java.time.LocalDate;

@Data
@NoArgsConstructor

public class ServicesDTO {
    private int id;

    private LocalDate date;

    private int hours_start;

    private int hours;

    private String location;

    private Boolean st_aceptar;

    private Boolean st_pagado;

    private Boolean st_anulado;

    private Client clients;

    private Bodyguard bodyguards;

    private Payment payment_method;

    private int review;
}
