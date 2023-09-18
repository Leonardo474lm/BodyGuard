package com.tf.bodyguard.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicesDTO {
    private Long id;
    private String typeservice;
    private LocalDate startdate;
    private LocalDate endsdate;
    private Integer time;
    private Time hour;

}
