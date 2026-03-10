package com.alura.challenge_forohub.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicoRepository extends JpaRepository <Topico, Long>{
    boolean existsByTituloAndMensaje(String titulo, String mensaje);

    List<Topico> findByCurso(String curso);
}

