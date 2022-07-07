package com.dh.clinica.controller;

import com.dh.clinica.model.Paciente;
import com.dh.clinica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    PacienteService pacienteService;

    @PostMapping()
    public ResponseEntity<String> registrarPaciente(@RequestBody Paciente paciente) {
        ResponseEntity<String> response = ResponseEntity.ok("Paciente Guardado");
        pacienteService.save(paciente);
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> search(@PathVariable Integer id) {
        Paciente paciente = pacienteService.getById(id);

        return ResponseEntity.ok(paciente);
    }

    @PutMapping()
    public ResponseEntity<String> update(@RequestBody Paciente paciente) {
        ResponseEntity<String> response = null;

        if (paciente.getId() != null && pacienteService.getById(paciente.getId()) != null){
            pacienteService.update(paciente);
            response = ResponseEntity.ok("Paciente Updated");
            return response;
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        ResponseEntity<String> response = null;
        if (pacienteService.getById(id) != null) {
            pacienteService.delete(id);
            response = ResponseEntity.ok("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }
}
