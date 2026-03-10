package com.alura.challenge_forohub.controller;

import com.alura.challenge_forohub.domain.DatosRegistroTopicos;
import com.alura.challenge_forohub.domain.Topico;
import com.alura.challenge_forohub.domain.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @Transactional
    @PostMapping
    public ResponseEntity registrarTopico(@RequestBody @Valid DatosRegistroTopicos datos) {

        if (repository.existsByTituloAndMensaje(datos.titulo(), datos.mensaje())) {
            return ResponseEntity.badRequest()
                    .body("Ya existe un tópico con el mismo título y mensaje");
        }

        Topico topico = new Topico(datos);
        repository.save(topico);

        return ResponseEntity.status(HttpStatus.CREATED).body(topico);
    }
}
