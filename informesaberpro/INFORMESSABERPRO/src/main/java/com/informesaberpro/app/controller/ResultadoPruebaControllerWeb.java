package com.informesaberpro.app.controller;

import com.informesaberpro.app.entity.Estudiante;
import com.informesaberpro.app.entity.ResultadoPrueba;
import com.informesaberpro.app.repository.EstudianteRepository;
import com.informesaberpro.app.repository.ResultadoPruebaRepository;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/resultados-pruebas")
public class ResultadoPruebaControllerWeb {

    @Autowired
    private ResultadoPruebaRepository resultadoPruebaRepositorio;

    @Autowired
    private EstudianteRepository estudianteRepositorio;

    @GetMapping
    public String listarResultados(Model model) {
        model.addAttribute("resultados", resultadoPruebaRepositorio.findAll());

        Map<String, Estudiante> estudiantesMap = estudianteRepositorio.findAll()
                .stream()
                .collect(Collectors.toMap(Estudiante::getId, Function.identity()));

        model.addAttribute("estudiantes", estudiantesMap);
        return "resultados-pruebas/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        ResultadoPrueba resultado = new ResultadoPrueba();
        model.addAttribute("resultadoPrueba", resultado);

        List<Estudiante> todosEstudiantes = estudianteRepositorio.findAll();
        Set<String> idsConResultado = resultadoPruebaRepositorio.findAll()
                .stream()
                .map(ResultadoPrueba::getIdEstudiante)
                .collect(Collectors.toSet());

        List<Estudiante> estudiantesSinResultado = todosEstudiantes.stream()
                .filter(est -> !idsConResultado.contains(est.getId()))
                .collect(Collectors.toList());

        model.addAttribute("estudiantes", estudiantesSinResultado);
        return "resultados-pruebas/formulario";
    }

    @PostMapping("/guardar")
    public String guardarResultado(@ModelAttribute ResultadoPrueba resultadoPrueba) {
        int puntaje = resultadoPrueba.getPuntaje();

        // 🟡 Validación: si el puntaje es 0 => Anulado
        if (puntaje == 0) {
            resultadoPrueba.setSaberProMediaNacional("Anulado");
            resultadoPrueba.setNivelSaberPro(0); // Nivel 0 para anulado
        } else {
            resultadoPrueba.setSaberProMediaNacional(puntaje > 125 ? "Aprobado" : "Reprobado");
            resultadoPrueba.setNivelSaberPro(calcularNivelSaberPro(puntaje));
        }

        resultadoPrueba.setComunicacionEscritaNivel(calcularNivel(resultadoPrueba.getComunicacionEscrita()));
        resultadoPrueba.setRazonamientoCuantitativoNivel(calcularNivel(resultadoPrueba.getRazonamientoCuantitativo()));
        resultadoPrueba.setLecturaCriticaNivel(calcularNivel(resultadoPrueba.getLecturaCritica()));
        resultadoPrueba.setCompetenciasCiudadanasNivel(calcularNivel(resultadoPrueba.getCompetenciasCiudadanas()));
        resultadoPrueba.setInglesNivel(calcularNivel(resultadoPrueba.getIngles()));
        resultadoPrueba.setFormulacionProyectosNivel(calcularNivel(resultadoPrueba.getFormulacionProyectos()));
        resultadoPrueba.setPensamientoCientificoNivel(calcularNivel(resultadoPrueba.getPensamientoCientifico()));
        resultadoPrueba.setDisenoSoftwareNivel(calcularNivel(resultadoPrueba.getDisenoSoftware()));

        resultadoPruebaRepositorio.save(resultadoPrueba);
        return "redirect:/resultados-pruebas";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable String id, Model model) {
        ResultadoPrueba resultadoPrueba = resultadoPruebaRepositorio.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
        model.addAttribute("resultadoPrueba", resultadoPrueba);
        model.addAttribute("estudiantes", estudianteRepositorio.findAll());
        return "resultados-pruebas/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarResultado(@PathVariable String id) {
        resultadoPruebaRepositorio.deleteById(id);
        return "redirect:/resultados-pruebas";
    }

    // Nivel por puntaje específico (para áreas individuales)
    private int calcularNivel(int puntaje) {
        if (puntaje < 50) return 1;
        if (puntaje < 100) return 2;
        if (puntaje < 150) return 3;
        return 4;
    }

    // Nivel Saber Pro general según el puntaje global
    private int calcularNivelSaberPro(int puntaje) {
        if (puntaje >= 0 && puntaje <= 132) return 1;
        if (puntaje >= 133 && puntaje <= 166) return 2;
        if (puntaje >= 167 && puntaje <= 206) return 3;
        if (puntaje >= 207 && puntaje <= 300) return 4;
        return 0;
    }
}
