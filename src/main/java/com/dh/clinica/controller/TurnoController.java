package com.dh.clinica.controller;

import com.dh.clinica.model.Turno;
import com.dh.clinica.service.OdontologoService;
import com.dh.clinica.service.PacienteService;
import com.dh.clinica.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    TurnoService turnoService;
    @Autowired
    PacienteService pacienteService;
    @Autowired
    OdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<String> registrarTurno(@RequestBody Turno turno) {
        ResponseEntity<String> response;
        if (pacienteService.getById(turno.getPaciente().getId()) != null && odontologoService.getById(turno.getOdontologo().getId()) != null)
            response = ResponseEntity.ok("Se guardo el turno");

        else
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        return response;


    }

    @GetMapping
    public ResponseEntity<List<Turno>> listar() {
        return ResponseEntity.ok(turnoService.searchAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        ResponseEntity<String> response;
        if (turnoService.getById(id) != null) { // Esta validacion no esta en el enunciado del ejericio, pero se las dejo para que la tengan.
            turnoService.delete(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @PutMapping
    public ResponseEntity<String> actualizarTurno(@RequestBody Turno turno) {
        turnoService.update(turno);
        return ResponseEntity.ok("Se actualizo el turno");

    }


}
