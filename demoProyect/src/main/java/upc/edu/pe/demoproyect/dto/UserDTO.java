package upc.edu.pe.demoproyect.dto;

import jakarta.persistence.Column;
import jdk.jfr.DataAmount;
import lombok.Data;

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

    private String id_City;

    private String id_User;



    //GETERS AND SETERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId_City() {
        return id_City;
    }

    public void setId_City(String id_City) {
        this.id_City = id_City;
    }

    public String getId_User() {
        return id_User;
    }

    public void setId_User(String id_User) {
        this.id_User = id_User;
    }
}
