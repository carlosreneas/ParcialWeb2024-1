package co.edu.ufps.semillero.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ufps.semillero.model.Grupo;
import co.edu.ufps.semillero.repository.GrupoRepository;

@RestController
@RequestMapping("/grupos")
public class GrupoController {
	
	@Autowired
	GrupoRepository grupoRepository;
	
	@GetMapping
	public List<Grupo> listarGrupos() {
		return grupoRepository.findAll();
	}

}
