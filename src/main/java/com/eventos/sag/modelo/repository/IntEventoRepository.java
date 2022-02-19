package com.eventos.sag.modelo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.eventos.sag.modelo.beans.Evento;

public interface IntEventoRepository extends JpaRepository<Evento, Integer> {
	
	@Query("select e from Evento e where e.estado='activo'")
	List<Evento> buscarActivos();
	
	@Query("select e from Evento e where e.destacado='1'")
	List<Evento> buscarDestacados();
	
	@Query("select e from Evento e where e.nombre like %:subcadena%")
	List<Evento> buscarPorSubcadena(@PathVariable("subcadena") String subcadena);
	
	@Query("select e.aforoMaximo-SUM(r.cantidad) from Reserva r,Evento e where e.idEvento = r.evento.idEvento and e.idEvento=?1")
	int buscarPlazasLibes(@PathVariable("idEvento") int idEvento);
}
