package co.edu.ufps.semillero.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.ufps.semillero.model.Semillero;
import co.edu.ufps.semillero.repository.SemilleroRepository;

@RestController
@RequestMapping("/semilleros")
public class SemilleroController {
	
	@Autowired
	SemilleroRepository semilleroRepository;
	
	@GetMapping
	public List<Semillero> listarSemilleros() {
		return semilleroRepository.findAll();
	}

}
