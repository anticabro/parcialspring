package com.informesaberpro.app.controller;
import com.informesaberpro.app.dto.ReporteEstudianteDTO; 
import com.informesaberpro.app.entity.Estudiante; 
import com.informesaberpro.app.entity.ResultadoPrueba; 
import com.informesaberpro.app.repository.EstudianteRepository; 
import com.informesaberpro.app.repository.ResultadoPruebaRepository; 
import org.springframework.beans.factory.annotation.Autowired; import org.springframework.stereotype.Controller; import org.springframework.ui.Model; import org.springframework.web.bind.annotation.GetMapping; import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList; import java.util.Comparator; import java.util.List; import java.util.stream.Collectors;



@Controller @RequestMapping("/reportes")
public class ReporteControllerWeb2 {
	@Autowired
	private EstudianteRepository estudianteRepositorio;

	@Autowired
	private ResultadoPruebaRepository resultadoPruebaRepositorio;

	private List<ReporteEstudianteDTO> obtenerTodosReportesEstudiantes() {
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

	@GetMapping("/todos2")
	public String mostrarReporteTodos(Model model) {
	    model.addAttribute("reportes", obtenerTodosReportesEstudiantes());
	    return "reportes/todos2";
	}

	@GetMapping("/ranking2")
	public String mostrarReporteRanking(Model model) {
	    List<ReporteEstudianteDTO> reportes = obtenerTodosReportesEstudiantes();
	    reportes = reportes.stream()
	            .sorted(Comparator.comparing(reporte -> reporte.getResultadoPrueba().getPuntaje(), Comparator.reverseOrder()))
	            .collect(Collectors.toList());
	    model.addAttribute("reportes", reportes);
	    return "reportes/ranking2";
	}
}
