package upc.edu.pe.demoproyect.dto;

import jakarta.persistence.Column;
import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UserDTO {
    private int id;

    private String dni;

    private String name;


    private String lastname;
    private String email;

    private int age;

    private String gender;

    private String phone;

    private String password;
    ///esto se tiene que cambiar luego para la implementacion de las tablas respectivas
    //private String district;




}
