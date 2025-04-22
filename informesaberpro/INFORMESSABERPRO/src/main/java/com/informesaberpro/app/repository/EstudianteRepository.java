package com.informesaberpro.app.repository;

import com.informesaberpro.app.entity.Estudiante;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EstudianteRepository extends MongoRepository<Estudiante, String> {
    Estudiante findByCorreoElectronicoAndNumeroDocumento(String correoElectronico, String numeroDocumento);
}
