package com.alura.challenge_forohub.domain;

public record DatosActualizarTopico(
        String titulo,
        String mensaje,
        String autor,
        String curso,
        String status
) {
}
