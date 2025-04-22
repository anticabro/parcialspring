package com.informesaberpro.app.controller;
import com.informesaberpro.app.dto.ReporteEstudianteDTO; 
import com.informesaberpro.app.entity.Estudiante; 
import com.informesaberpro.app.entity.ResultadoPrueba; 
import com.informesaberpro.app.repository.EstudianteRepository; 
import com.informesaberpro.app.repository.ResultadoPruebaRepository; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList; 
import java.util.Comparator;
import java.util.List; 
import java.util.stream.Collectors;
@RestController @RequestMapping("/api/reportes")

public class ReporteController2 {
	@Autowired
	private EstudianteRepository estudianteRepositorio;

	@Autowired
	private ResultadoPruebaRepository resultadoPruebaRepositorio;

	@GetMapping("/todos2")
	public List<ReporteEstudianteDTO> obtenerTodosReportesEstudiantes() {
	    List<Estudiante> estudiantes = estudianteRepositorio.findAll();
	    List<ReporteEstudianteDTO> reportes = new ArrayList<>();

	    for (Estudiante estudiante : estudiantes) {
	        List<ResultadoPrueba> resultados = resultadoPruebaRepositorio.findByIdEstudiante(estudiante.getId());
	        if (!resultados.isEmpty()) {
	            reportes.add(new ReporteEstudianteDTO(estudiante, resultados.get(0)));
	        }
	    }
	    return reportes;
	}

	@GetMapping("/ranking2")
	public List<ReporteEstudianteDTO> obtenerReporteRanking() {
	    List<ReporteEstudianteDTO> reportes = obtenerTodosReportesEstudiantes();
	    return reportes.stream()
	            .sorted(Comparator.comparing(reporte -> reporte.getResultadoPrueba().getPuntaje(), Comparator.reverseOrder()))
	            .collect(Collectors.toList());
	}
}
