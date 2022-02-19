package com.eventos.sag.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eventos.sag.modelo.beans.Evento;
import com.eventos.sag.modelo.repository.IntEventoRepository;

@Repository
public class EventoDaoImpl implements IntEventoDao {
	
	@Autowired
	IntEventoRepository eventoRepository;

	@Override
	public Evento buscarPorId(int idEvento) {
		return eventoRepository.findById(idEvento).orElse(null);
	}

	@Override
	public int altaEvento(Evento evento) {
		if (buscarPorId(evento.getIdEvento()) == null) {
			eventoRepository.save(evento);
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public List<Evento> buscarActivos() {
		return eventoRepository.buscarActivos();
	}

	@Override
	public List<Evento> buscarDestacados() {
		return eventoRepository.buscarDestacados();
	}

	@Override
	public int modificarEvento(Evento evento) {
		if (buscarPorId(evento.getIdEvento()) != null) {
			eventoRepository.save(evento);
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int eliminarEvento(int idEvento) {
		if (buscarPorId(idEvento) != null) {
			eventoRepository.deleteById(idEvento);			
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public List<Evento> buscarPorSubcadena(String subcadena) {
		return eventoRepository.buscarPorSubcadena(subcadena);
	}

	@Override
	public int buscarPlazasLibres(int idEvento) {
		return eventoRepository.buscarPlazasLibes(idEvento);
	}

}
