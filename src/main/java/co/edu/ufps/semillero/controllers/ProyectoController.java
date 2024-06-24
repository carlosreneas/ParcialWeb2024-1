package co.edu.ufps.semillero.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ufps.semillero.model.Proyecto;
import co.edu.ufps.semillero.repository.ProyectoRepository;

@RestController
@RequestMapping("/proyectos")
public class ProyectoController {
	
	@Autowired
	ProyectoRepository proyectoRepository;
	
	@GetMapping
	public List<Proyecto> listarProyectos() {
		return proyectoRepository.findAll();
	}

}
