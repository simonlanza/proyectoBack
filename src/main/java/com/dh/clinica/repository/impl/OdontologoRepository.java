package com.dh.clinica.repository.impl;

import com.dh.clinica.model.Odontologo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OdontologoRepository extends MongoRepository<Odontologo, Integer> {
}
