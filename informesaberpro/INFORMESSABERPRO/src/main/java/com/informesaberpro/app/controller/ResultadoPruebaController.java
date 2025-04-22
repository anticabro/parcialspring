package com.informesaberpro.app.controller;

import com.informesaberpro.app.entity.ResultadoPrueba;
import com.informesaberpro.app.repository.ResultadoPruebaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/resultados-pruebas")
public class ResultadoPruebaController {

    @Autowired
    private ResultadoPruebaRepository resultadoPruebaRepositorio;

    private int calcularNivelGeneral(int puntaje) {
        if (puntaje <= 125) {
            return 1;
        } else if (puntaje <= 153) {
            return 2;
        } else {
            return 3;
        }
    }

    private int calcularNivelCategoria(int puntaje) {
        if (puntaje <= 125) {
            return 1;
        } else if (puntaje <= 150) {
            return 2;
        } else if (puntaje <= 175) {
            return 3;
        } else {
            return 4;
        }
    }
    private void calcularNiveles(ResultadoPrueba resultadoPrueba) {
        int puntaje = resultadoPrueba.getPuntaje();

        if (puntaje < 1) {
            // Si el puntaje es menor a 1, anulado
            resultadoPrueba.setSaberProMediaNacional("Anulado");
            resultadoPrueba.setNivelSaberPro(0);
            resultadoPrueba.setComunicacionEscritaNivel(0);
            resultadoPrueba.setRazonamientoCuantitativoNivel(0);
            resultadoPrueba.setLecturaCriticaNivel(0);
            resultadoPrueba.setCompetenciasCiudadanasNivel(0);
            resultadoPrueba.setInglesNivel(0);
            resultadoPrueba.setFormulacionProyectosNivel(0);
            resultadoPrueba.setPensamientoCientificoNivel(0);
            resultadoPrueba.setDisenoSoftwareNivel(0);
        } else {
            resultadoPrueba.setSaberProMediaNacional(puntaje > 125 ? "Aprobado" : "Reprobado");
            resultadoPrueba.setNivelSaberPro(calcularNivelGeneral(puntaje));
            resultadoPrueba.setComunicacionEscritaNivel(calcularNivelCategoria(resultadoPrueba.getComunicacionEscrita()));
            resultadoPrueba.setRazonamientoCuantitativoNivel(calcularNivelCategoria(resultadoPrueba.getRazonamientoCuantitativo()));
            resultadoPrueba.setLecturaCriticaNivel(calcularNivelCategoria(resultadoPrueba.getLecturaCritica()));
            resultadoPrueba.setCompetenciasCiudadanasNivel(calcularNivelCategoria(resultadoPrueba.getCompetenciasCiudadanas()));
            resultadoPrueba.setInglesNivel(calcularNivelCategoria(resultadoPrueba.getIngles()));
            resultadoPrueba.setFormulacionProyectosNivel(calcularNivelCategoria(resultadoPrueba.getFormulacionProyectos()));
            resultadoPrueba.setPensamientoCientificoNivel(calcularNivelCategoria(resultadoPrueba.getPensamientoCientifico()));
            resultadoPrueba.setDisenoSoftwareNivel(calcularNivelCategoria(resultadoPrueba.getDisenoSoftware()));
        }
    }



    @PostMapping
    public ResponseEntity<?> crearResultadoPrueba(@RequestBody ResultadoPrueba resultadoPrueba) {
        List<ResultadoPrueba> existentes = resultadoPruebaRepositorio.findByIdEstudiante(resultadoPrueba.getIdEstudiante());

        if (!existentes.isEmpty()) {
            return ResponseEntity
                    .badRequest()
                    .body("Este estudiante ya tiene un resultado registrado.");
        }

        calcularNiveles(resultadoPrueba);
        ResultadoPrueba guardado = resultadoPruebaRepositorio.save(resultadoPrueba);
        return ResponseEntity.ok(guardado);
    }


    @GetMapping
    public List<ResultadoPrueba> obtenerTodosResultadosPruebas() {
        return resultadoPruebaRepositorio.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultadoPrueba> obtenerResultadoPruebaPorId(@PathVariable String id) {
        Optional<ResultadoPrueba> resultadoPrueba = resultadoPruebaRepositorio.findById(id);
        return resultadoPrueba.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResultadoPrueba actualizarResultadoPrueba(@PathVariable String id, @RequestBody ResultadoPrueba resultadoPrueba) {
        resultadoPrueba.setId(id);
        calcularNiveles(resultadoPrueba);
        return resultadoPruebaRepositorio.save(resultadoPrueba);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarResultadoPrueba(@PathVariable String id) {
        resultadoPruebaRepositorio.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
