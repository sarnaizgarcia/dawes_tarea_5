package com.eventos.sag.modelo.dao;

import java.util.List;

import com.eventos.sag.modelo.beans.Evento;


public interface IntEventoDao {

	List<Evento> buscarTodos();
	Evento buscarPorId(int idEvento);
	int altaEvento(Evento evento);
	
}
