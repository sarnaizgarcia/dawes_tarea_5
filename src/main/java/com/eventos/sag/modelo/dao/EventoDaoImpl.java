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
	public List<Evento> buscarTodos() {
		return eventoRepository.findAll();
	}

}
