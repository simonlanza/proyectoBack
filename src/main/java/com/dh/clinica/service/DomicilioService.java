package com.dh.clinica.service;


import com.dh.clinica.model.Odontologo;
import com.dh.clinica.repository.IDao;
import com.dh.clinica.model.Domicilio;
import com.dh.clinica.repository.impl.DomicilioRepository;
import com.dh.clinica.repository.impl.OdontologoRepository;
import org.apache.log4j.Logger;


import java.util.List;
import java.util.Optional;

public class DomicilioService {
    private static final Logger logger = Logger.getLogger(DomicilioService.class);
    DomicilioRepository domicilioRepository;

    public String save(Domicilio d){
        if (domicilioRepository.save(d)!= null){
            logger.info("Dentist was succesfully saved");
            return "New dentist saved";
        }else {
            logger.error("There was something wrong...");
            return "There was something wrong...";
        }
    }

    public Domicilio getById(Integer id){
        if (domicilioRepository.existsById(id)){
            Domicilio domicilio = domicilioRepository.findById(id).get();
            logger.info("Looking for domicilio with id: " + id );
            return domicilio;
        }
        logger.error("Domicilio with id: " + id + "was not found");
        return null;
    }
    public List<Domicilio> searchAll(){
        logger.info("Searching all domicilios");
        return domicilioRepository.findAll();
    }
    public void delete(Integer id){
        if (domicilioRepository.findById(id).isPresent()){
            domicilioRepository.deleteById(id);
            logger.info("Domicilio with id " + id + "was succesfully deleted");
        };
    }

    public String update (Domicilio d){
        Integer domicilioId = d.getId();

        if(domicilioRepository.findById(domicilioId).isPresent()) {
            Domicilio domicilioAModificar = domicilioRepository.findById(domicilioId).get();

            domicilioAModificar.setCalle(d.getCalle());
            domicilioAModificar.setNumero(d.getNumero());
            domicilioAModificar.setLocalidad(d.getLocalidad());
            domicilioAModificar.setProvincia(d.getProvincia());

            domicilioRepository.save(domicilioAModificar);
            logger.info("Domicilio " + domicilioId +" was succesfully modified.");
            return "Domiciliio with Id: " + domicilioId + " was modified.";

        } else {
            logger.error("Domicilio doesn't exist");
            return "Domicilio with Id " + domicilioId + " does not exist.";
        }
    }


}
