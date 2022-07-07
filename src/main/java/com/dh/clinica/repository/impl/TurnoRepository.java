package com.dh.clinica.repository.impl;

import com.dh.clinica.model.Turno;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TurnoRepository extends MongoRepository<Turno, Integer> {
}
