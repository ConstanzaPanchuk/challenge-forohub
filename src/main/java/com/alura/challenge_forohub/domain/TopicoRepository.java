package com.alura.challenge_forohub.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository <Topico, Long>{
    boolean existsByTituloAndMensaje(String titulo, String mensaje);
}
