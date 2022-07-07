package com.dh.clinica.service;

import com.dh.clinica.model.Paciente;
import com.dh.clinica.repository.IDao;
import com.dh.clinica.model.Turno;
import com.dh.clinica.repository.impl.TurnoRepository;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class TurnoService {
    private static final Logger logger = Logger.getLogger(TurnoService.class);
    TurnoRepository turnoRepository;

    public String save(Turno t){
        if(turnoRepository.save(t)!=null){
            logger.info("TUrno was succesfully saved");
            return "New turno saved";
        } else {
            logger.error("There was something wrong...");
            return "There was something wrong";
        }
    }
    public List<Turno> searchAll(){
        logger.info("Searching all turno");
        return turnoRepository.findAll();
    }
    public void delete(Integer id){
        if (turnoRepository.findById(id).isPresent()){
            turnoRepository.deleteById(id);
            logger.info("Paciente with id " + id + "was succesfully deleted");
        };
    }
    public String update(Turno t){
        Integer turnoId = t.getId();

        if (turnoRepository.findById(turnoId).isPresent()) {
            Turno turnoAModificar = turnoRepository.findById(turnoId).get();

            turnoAModificar.setPaciente(t.getPaciente());
            turnoAModificar.setDate(t.getDate());
            turnoAModificar.setOdontologo(t.getOdontologo());

            turnoRepository.save(turnoAModificar);
            logger.info("Turno " + turnoId + " was succesfully modified");
            return "Turno with id " + turnoId + " was modified";

        } else {
            logger.error("Turno Doesen't exist");
            return "Turno with id " + turnoId + " doesen't exists";
        }

    }
    public Turno getById(Integer id){
        if(turnoRepository.existsById(id)){
            Turno turno = turnoRepository.findById(id).get();
            logger.info("Looking for turno with id: "+ id);
            return turno;
        }
        logger.error("Domicilio with id " + id + " was not found");
        return null;
    }

}
