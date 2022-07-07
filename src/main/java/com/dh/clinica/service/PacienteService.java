package com.dh.clinica.service;


import com.dh.clinica.model.Domicilio;
import com.dh.clinica.repository.IDao;
import com.dh.clinica.model.Paciente;
import com.dh.clinica.repository.impl.PacienteRepository;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class PacienteService {
    private static final Logger logger = Logger.getLogger(PacienteService.class);
    PacienteRepository pacienteRepository;

    public String save(Paciente p){
        if (pacienteRepository.save(p)!= null){
            logger.info("Dentist was succesfully saved");
            return "New dentist saved";
        }else {
            logger.error("There was something wrong...");
            return "There was something wrong...";
        }
    }

    public Paciente getById(Integer id){
        if (pacienteRepository.existsById(id)){
            Paciente paciente = pacienteRepository.findById(id).get();
            logger.info("Looking for domicilio with id: " + id );
            return paciente;
        }
        logger.error("Domicilio with id: " + id + "was not found");
        return null;
    }

    public List<Paciente> searchAll(){
        logger.info("Searching all domicilios");
        return pacienteRepository.findAll();
    }

    public void delete(Integer id){
        if (pacienteRepository.findById(id).isPresent()){
            pacienteRepository.deleteById(id);
            logger.info("Paciente with id " + id + "was succesfully deleted");
        };
    }

    public String update (Paciente p){
        Integer pacienteId = p.getId();

        if(pacienteRepository.findById(pacienteId).isPresent()) {
            Paciente pacienteAModificar = pacienteRepository.findById(pacienteId).get();

            pacienteAModificar.setNombre(p.getNombre());
            pacienteAModificar.setApellido(p.getApellido());
            pacienteAModificar.setDni(p.getDni());
            pacienteAModificar.setFechaIngreso(p.getFechaIngreso());
            pacienteAModificar.setDomicilio(p.getDomicilio());

            pacienteRepository.save(pacienteAModificar);
            logger.info("Domicilio " + pacienteId +" was succesfully modified.");
            return "Domiciliio with Id: " + pacienteId + " was modified.";

        } else {
            logger.error("Domicilio doesn't exist");
            return "Domicilio with Id " + pacienteId + " does not exist.";
        }
    }

}
