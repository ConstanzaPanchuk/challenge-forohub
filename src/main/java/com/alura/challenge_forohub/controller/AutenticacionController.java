package com.alura.challenge_forohub.controller;

import com.alura.challenge_forohub.domain.usuario.DatosAutenticacionUsuario;
import com.alura.challenge_forohub.domain.usuario.Usuario;
import com.alura.challenge_forohub.infra.security.DatosTokenJWT;
import com.alura.challenge_forohub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticar(@RequestBody @Valid DatosAutenticacionUsuario datos) {

        var authenticationToken = new UsernamePasswordAuthenticationToken(
                datos.correoElectronico(),
                datos.contrasena()
        );

        var autenticacion = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.generarToken((Usuario) autenticacion.getPrincipal());

        return ResponseEntity.ok(new DatosTokenJWT(tokenJWT));
    }
}
