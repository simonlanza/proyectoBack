package com.dh.clinica.controller;

import com.dh.clinica.model.Odontologo;

import com.dh.clinica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    @Autowired
    public OdontologoService odontologoService;

    @PostMapping()
    public ResponseEntity<String> save(@RequestBody Odontologo o) {
        ResponseEntity<String> response = null;
        if(odontologoService.save(o) != null) {
            response = ResponseEntity.ok("Dentist created.");
        } else {
            response = ResponseEntity.internalServerError().body("Oops");
        }
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> getById(@PathVariable Integer id) {
        Odontologo odontologo = odontologoService.getById(id);

        return ResponseEntity.ok(odontologo);
    }

    @PutMapping()
    public ResponseEntity<String> update(@RequestBody Odontologo odontologo) {
        ResponseEntity<String> response = null;
        int odo = odontologoService.getById(odontologo.getId()).getId();
        if (odontologo.getId() != null && odo != 0)
            response = ResponseEntity.ok("Se actualizo el odontologo");
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        ResponseEntity<String> response = null;

        if (odontologoService.getById(id) != null) {
            odontologoService.delete(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }
    @GetMapping
    public ResponseEntity<List<Odontologo>> searchAll(){
        return ResponseEntity.ok(odontologoService.searchAll());
    }



}
