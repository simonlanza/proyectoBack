package com.dh.clinica.repository.impl;

import com.dh.clinica.model.Domicilio;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DomicilioRepository extends MongoRepository<Domicilio, Integer> {
}
