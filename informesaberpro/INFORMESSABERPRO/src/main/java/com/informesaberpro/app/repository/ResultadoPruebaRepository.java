package com.informesaberpro.app.repository;

import com.informesaberpro.app.entity.ResultadoPrueba;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface ResultadoPruebaRepository extends MongoRepository<ResultadoPrueba, String> {
    List<ResultadoPrueba> findByIdEstudiante(String idEstudiante);
}
