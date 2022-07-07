package com.dh.clinica.repository.impl;

import com.dh.clinica.model.Paciente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PacienteRepository extends MongoRepository<Paciente, Integer> {
}
