package com.eventos.sag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventos.sag.modelo.beans.Evento;
import com.eventos.sag.modelo.dao.IntEventoDao;

@RestController
@RequestMapping("/rest/eventos")
public class EventoController {
	
	@Autowired
	private IntEventoDao eventoDao; 
	
	@GetMapping("/activos")
	public List<Evento> verEventosActivos() {
		return eventoDao.buscarActivos();
	}
	
	@PostMapping("/alta")
	public String procesarAlta(@RequestBody Evento evento) {
		if (eventoDao.altaEvento(evento) == 1) {	
			return "Evento dado de alta";
		} else {
			return "No se pudo dar de alta el evento";
		}
	}
	
	@GetMapping("/destacados")
	public List<Evento> verEventosDestacados() {
		return eventoDao.buscarDestacados();
	}
	
	@PutMapping("/modificar")
	public String modificarEvento(@RequestBody Evento evento) {
		if (eventoDao.modificarEvento(evento) == 1) {	
			return "Evento modificado";
		} else {
			return "No se pudo modificar el evento";
		}
	}
	
	@DeleteMapping("/eliminar/{idEvento}")
	public String eliminarEvento(@PathVariable("idEvento") int idEvento) {
		if (eventoDao.eliminarEvento(idEvento) == 1) {	
			return "Evento eliminado";
		} else {
			return "No se pudo eliminar el evento";
		}
	}

	@GetMapping("/verUno/{idEvento}")
	public Evento verEvento(@PathVariable("idEvento") int idEvento) {
		return eventoDao.buscarPorId(idEvento);
	}

	@GetMapping("/buscarEventos/{subcadena}")
	public List<Evento> buscarPorSubcadena(@PathVariable("subcadena") String subcadena) {
		return eventoDao.buscarPorSubcadena(subcadena);
	}

	@GetMapping("/plazasQuedan/{idEvento}")
	public String vezPlazasLibres(@PathVariable("idEvento") int idEvento) {
		int plazasDisponibles = eventoDao.buscarPlazasLibres(idEvento);
		return "{quedan_plazas}: " + plazasDisponibles + "}";
	}
	
}
