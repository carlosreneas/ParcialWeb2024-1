package co.edu.ufps.semillero.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ufps.semillero.model.Estudiante;
import co.edu.ufps.semillero.model.NivelFormacion;
import co.edu.ufps.semillero.repository.NivelFormacionRepository;

@RestController
@RequestMapping("/nivel_formaciones")
public class NivelFormacionController {
	
	@Autowired
	NivelFormacionRepository nivelFormacionRepository;
	
	@GetMapping
	public List<NivelFormacion> listarNivelFormacion() {
		return nivelFormacionRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public NivelFormacion obtenerNivelFormacion(@PathVariable Integer id) {
		Optional<NivelFormacion> nivelFormacionOptional = nivelFormacionRepository.findById(id);
		if (nivelFormacionOptional.isPresent()) {
			return nivelFormacionOptional.get();
		}
		
		return null;
	}
	
	@PostMapping
	public NivelFormacion crearNivelFormacion(@RequestBody NivelFormacion nivelFormacion) {
		nivelFormacionRepository.save(nivelFormacion);
		return nivelFormacion;
	}
	
	@PutMapping("/{id}")
	public NivelFormacion actualizarNivelFormacion(@RequestBody NivelFormacion nivelFormacion, @PathVariable Integer id) {
		Optional<NivelFormacion> nivelFormacionOptional = nivelFormacionRepository.findById(id);
		if (nivelFormacionOptional.isPresent()) {
			NivelFormacion nivelFormacionActual = nivelFormacionOptional.get();
			nivelFormacion.setNombre(nivelFormacion.getNombre());
			nivelFormacionRepository.save(nivelFormacionActual);
			return nivelFormacionActual;
		}
		return null;
	}
	
	
	@DeleteMapping("/{id}")
	public NivelFormacion deleteNivelFormacion(@PathVariable Integer id) {
		Optional<NivelFormacion> nivelFormacionOptional = nivelFormacionRepository.findById(id);
		if (nivelFormacionOptional.isPresent()) {
			nivelFormacionRepository.deleteById(id);
			return nivelFormacionOptional.get();
		}
		
		return null;
	}

}
