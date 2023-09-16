package upc.edu.pe.demoproyect.dto;


import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import upc.edu.pe.demoproyect.entities.Bodyguard;
import upc.edu.pe.demoproyect.entities.Client;
import upc.edu.pe.demoproyect.entities.Payment_method;

import java.sql.Time;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicesDTO {
    private int id;
    private LocalDate date;
    private int hours_start;
    private int hours_end;
    private String typeservice;
    private String location_encuentro;
    private Boolean st_pagado;
    private Boolean st_anulado;
    private int review;
    private Client clients;
    private Bodyguard bodyguards;
    private Payment_method payment_method;

}
