package com.informesaberpro.app.controller;
import com.informesaberpro.app.entity.Estudiante; 
import com.informesaberpro.app.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.*;
import java.util.List; 
import java.util.Optional;

@RestController @RequestMapping("/api/estudiantes")
public class EstudianteController {
	@Autowired
	private EstudianteRepository estudianteRepositorio;

	@PostMapping
	public Estudiante crearEstudiante(@RequestBody Estudiante estudiante) {
	    return estudianteRepositorio.save(estudiante);
	}

	@GetMapping
	public List<Estudiante> obtenerTodosEstudiantes() {
	    return estudianteRepositorio.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Estudiante> obtenerEstudiantePorId(@PathVariable String id) {
	    Optional<Estudiante> estudiante = estudianteRepositorio.findById(id);
	    return estudiante.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Estudiante> actualizarEstudiante(@PathVariable String id, @RequestBody Estudiante estudiante) {
	    estudiante.setId(id);
	    return ResponseEntity.ok(estudianteRepositorio.save(estudiante));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarEstudiante(@PathVariable String id) {
	    estudianteRepositorio.deleteById(id);
	    return ResponseEntity.ok().build();
	}
}