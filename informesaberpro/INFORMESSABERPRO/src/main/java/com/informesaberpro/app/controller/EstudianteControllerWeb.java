package com.informesaberpro.app.controller;
import com.informesaberpro.app.entity.Estudiante; 
import com.informesaberpro.app.repository.EstudianteRepository; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.*;



@Controller @RequestMapping("/estudiantes")
public class EstudianteControllerWeb {
	@Autowired
	private EstudianteRepository estudianteRepositorio;

	@GetMapping
	public String listarEstudiantes(Model model) {
	    model.addAttribute("estudiantes", estudianteRepositorio.findAll());
	    return "estudiantes/lista";
	}

	@GetMapping("/nuevo")
	public String mostrarFormularioNuevo(Model model) {
	    model.addAttribute("estudiante", new Estudiante());
	    return "estudiantes/formulario";
	}

	@PostMapping("/guardar")
	public String guardarEstudiante(@ModelAttribute Estudiante estudiante) {
	    estudianteRepositorio.save(estudiante);
	    return "redirect:/estudiantes";
	}

	@GetMapping("/editar/{id}")
	public String mostrarFormularioEditar(@PathVariable String id, Model model) {
	    Estudiante estudiante = estudianteRepositorio.findById(id)
	            .orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
	    model.addAttribute("estudiante", estudiante);
	    return "estudiantes/formulario";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminarEstudiante(@PathVariable String id) {
	    estudianteRepositorio.deleteById(id);
	    return "redirect:/estudiantes";
	}
	@GetMapping("/panel")
	public String mostrarPanelEstudiantes() {
	    return "estudiantes/panel";
	}

}