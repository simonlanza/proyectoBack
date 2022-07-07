package com.dh.clinica.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Getter
@Setter
@ToString
@Document(collection = "Turno")

public class Turno {
    @Id
    private Integer id;
    @Field (name = "paciente")
    private Paciente paciente;
    @Field (name = "odontologo")
    private Odontologo odontologo;
    private Date date;

    public Turno(Paciente paciente, Odontologo odontologo, Date date) {
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.date = date;
    }

    public Turno() {
    }
}
