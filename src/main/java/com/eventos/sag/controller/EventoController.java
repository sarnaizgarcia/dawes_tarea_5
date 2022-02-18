package com.eventos.sag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
		return eventoDao.buscarTodos();
	}
	
	
	
//	“/activos”:
//		Devolver todos los eventos activos
//		“/destacados”
//		Devolver todos los eventos destacados
//		“/buscarEventos/{subcadena}”
//		Devolvemos todos los eventos cuyo nombre de evento contenga la cadena de caracteres introducida por PathVariable en la URL
//		“/plazasQuedan/{idEvento}”
//		Devolvemos el numero de plazas que quedan sin reservar, de la forma {“quedan_plazas” : 26}
//		“/verUno/{idEvento}”
//		Devolvemos el Evento cuyo código de evento coincida con el introducido por PathVariable en la URL.
//		“/alta”
//		Nos pasan un json con los datos del evento y lo damos de alta, la salida es un mensaje “Evento dado de Alta”.
//		“/modificar”
//		Nos pasan un json con los datos del evento y lo modificamos en la base de datos, la salida es un mensaje “Evento Modificado”.
//		“/eliminar/{idEvento}”
//		Nos pasan por @PathVariable el identificador del evento y lo eliminamos de la tabla, la salida es un mensaje “Evento Eliminado”.
	
}
