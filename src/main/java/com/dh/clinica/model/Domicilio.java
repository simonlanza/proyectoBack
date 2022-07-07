package com.dh.clinica.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "Domicilio")

public class Domicilio {
    @Id
    private Integer id;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;

    public Domicilio() {
    }

    public Domicilio( String calle, String numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

}
