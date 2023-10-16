package com.example.msauth.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.msauth.models.Usuario;
import com.example.msauth.services.UsuarioService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @ApiOperation("Salvar usuário.")
    @ApiResponse(code = 200, message = "Usuario criado novo usuário")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario salvar(@RequestBody @Valid Usuario usuario) {
        return this.usuarioService.save(usuario);
    }

    @GetMapping
    @ApiOperation("Listar todos usuarios.")
    @ApiResponse(code = 302, message = "Usuários encontrados.")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Usuario> listarTodos() {
        return this.usuarioService.listarTodos();
    }
}
