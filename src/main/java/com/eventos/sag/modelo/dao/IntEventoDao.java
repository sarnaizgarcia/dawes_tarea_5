package com.eventos.sag.modelo.dao;

import java.util.List;

import com.eventos.sag.modelo.beans.Evento;


public interface IntEventoDao {

	Evento buscarPorId(int idEvento);
	int altaEvento(Evento evento);
	List<Evento> buscarActivos();
	List<Evento> buscarDestacados();
	int modificarEvento(Evento evento);
	int eliminarEvento(int idEvento);
	List<Evento> buscarPorSubcadena(String subcadena);
	int buscarPlazasLibres(int idEvento);

}
