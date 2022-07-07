package com.dh.clinica.service;

import com.dh.clinica.model.Paciente;
import com.dh.clinica.repository.IDao;
import com.dh.clinica.model.Odontologo;
import com.dh.clinica.repository.impl.OdontologoRepository;
import org.apache.log4j.Logger;


import java.util.List;
import java.util.Optional;

public class OdontologoService {
    private static final Logger logger = Logger.getLogger(OdontologoService.class);
    OdontologoRepository odontologoRepository;

    public String save(Odontologo o) {
        if (odontologoRepository.save(o)!=null){
            logger.info("Odontologo was succesfuly saved");
            return "New odontolodo saved";
        } else {
            logger.error("There was something wrong");
            return "There was somethin wrong";
        }
    }

    public void delete(Integer id) {
       if (odontologoRepository.findById(id).isPresent()){
           odontologoRepository.deleteById(id);
           logger.info("Odontologo with id " + id + " was succesfully deleted");
       }
    }

    public Odontologo getById(Integer id) {
        if (odontologoRepository.existsById(id)){
            Odontologo odontologo = odontologoRepository.findById(id).get();
            logger.info("Looking for odontologo with id: " + id );
            return odontologo;
        }
        logger.error("Odontolodo with id " + id + " was not found");
        return null;
    }

    public List<Odontologo> searchAll() {
        logger.info("Searching all Odonotologos");
        return odontologoRepository.findAll();
    }

    public String update(Odontologo o) {
        Integer odontologoId = o.getId();

        if(odontologoRepository.findById(odontologoId).isPresent()) {
            Odontologo odontologoAModificar = odontologoRepository.findById(odontologoId).get();

            odontologoAModificar.setNombre(o.getNombre());
            odontologoAModificar.setApellido(o.getApellido());
            odontologoAModificar.setMatricula(o.getMatricula());

            odontologoRepository.save(odontologoAModificar);
            logger.info("Domicilio " + odontologoId +" was succesfully modified.");
            return "Domiciliio with Id: " + odontologoId + " was modified.";

        } else {
            logger.error("Domicilio doesn't exist");
            return "Domicilio with Id " + odontologoId + " does not exist.";
        }
    }


}
