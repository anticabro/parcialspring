package com.informesaberpro.app.repository;

import com.informesaberpro.app.entity.Coordinacion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CoordinacionRepository extends MongoRepository<Coordinacion, String> {
    Coordinacion findByUsuario(String usuario);
}
