package com.eventos.sag.modelo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eventos.sag.modelo.repository.IntReservaRepository;

@Repository
public class ReservaDaoImpl implements IntReservaDao {
	
	@Autowired
	IntReservaRepository reservaRepository;

	@Override
	public int buscarPlazasLibes(int idEvento) {
		return reservaRepository.buscarPlazasLibes(idEvento);
	}

}
