package com.eventos.sag.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.eventos.sag.modelo.beans.Reserva;

public interface IntReservaRepository extends JpaRepository<Reserva, Integer> {
	
	@Query("select e.aforoMaximo - (select COALESCE(sum(r.cantidad), 0) from Reserva r where r.evento.idEvento=e.idEvento) from Evento e where idEvento=:idEvento")
	int buscarPlazasLibes(@PathVariable("idEvento") int idEvento);
}
