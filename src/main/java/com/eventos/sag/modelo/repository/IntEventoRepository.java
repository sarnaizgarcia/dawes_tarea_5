package com.eventos.sag.modelo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventos.sag.modelo.beans.Evento;

public interface IntEventoRepository extends JpaRepository<Evento, Integer> {

}
