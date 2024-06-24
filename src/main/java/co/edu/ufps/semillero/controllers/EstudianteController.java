package co.edu.ufps.semillero.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ufps.semillero.model.Estudiante;
import co.edu.ufps.semillero.repository.EstudianteRepository;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {
	
	@Autowired
	EstudianteRepository estudianteRepository;
	
	@GetMapping
	public List<Estudiante> listarEstudiantes() {
		return estudianteRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Estudiante obtenerEstudiante(@PathVariable Integer id) {
		Optional<Estudiante> estudianteOptional = estudianteRepository.findById(id);
		if (estudianteOptional.isPresent()) {
			return estudianteOptional.get();
		}
		
		return null;
	}
	
	
	@DeleteMapping("/{id}")
	public Estudiante deleteEstudiante(@PathVariable Integer id) {
		Optional<Estudiante> estudianteOptional = estudianteRepository.findById(id);
		if (estudianteOptional.isPresent()) {
			estudianteRepository.deleteById(id);
			return estudianteOptional.get();
		}
		
		return null;
	}

}
