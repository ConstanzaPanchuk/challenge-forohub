package com.alura.challenge_forohub.controller;

import com.alura.challenge_forohub.domain.DatosActualizarTopico;
import com.alura.challenge_forohub.domain.DatosRegistroTopicos;
import com.alura.challenge_forohub.domain.Topico;
import com.alura.challenge_forohub.domain.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping
    public ResponseEntity<Page<Topico>> listarTopicos(
            @PageableDefault(size = 10, sort = "fechaCreacion")
            Pageable paginacion) {
        return ResponseEntity.ok(repository.findAll(paginacion));
    }

    @GetMapping("/curso")
    public ResponseEntity<List<Topico>> listarPorCurso(@RequestParam String curso) {
        return ResponseEntity.ok(repository.findByCurso(curso));
    }

    @GetMapping("/{id}")
    public ResponseEntity detallarTopico(@PathVariable Long id) {

        var topico = repository.findById(id);
        if (topico.isPresent()) {
            return ResponseEntity.ok(topico.get());
        }
        return ResponseEntity.notFound().build();
    }

//    @Transactional
//    @PutMapping("/{id}")
//    public ResponseEntity actualizarTopico(@PathVariable Long id, @RequestBody @Valid DatosActualizarTopico datos) {
//
//        var topico = repository.getReferenceById(id);
//        topico.actualizarInformacion(datos);
//
//        return ResponseEntity.ok(topico);
//    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity actualizarTopico(@PathVariable Long id, @RequestBody @Valid DatosActualizarTopico datos) {

        var topicoOptional = repository.findById(id);

        if (topicoOptional.isPresent()) {
            var topico = topicoOptional.get();
            topico.actualizarInformacion(datos);
            return ResponseEntity.ok(topico);
        }
        return ResponseEntity.notFound().build();
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminarTopico(@PathVariable Long id) {

        var topico = repository.findById(id);

        if (topico.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
