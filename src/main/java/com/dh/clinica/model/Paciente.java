package com.dh.clinica.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Getter
@Setter
@ToString
@Document(collection = "Paciente")

public class Paciente {
    @Id
    private Integer id;
    private String nombre;
    private String apellido;
    private String dni;
    private Date fechaIngreso;
    @Field(name = "direccion")
    private Domicilio domicilio;

    public Paciente() {
    }

    public Paciente(String nombre, String apellido, String dni, Date fechaIngreso, Domicilio domicilio) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }

}
