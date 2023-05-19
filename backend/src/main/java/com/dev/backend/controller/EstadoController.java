package com.dev.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.backend.entity.Estado;
import com.dev.backend.service.EstadoService;

import jakarta.websocket.server.PathParam;

//Responde a requisições tipo Rest
@RestController
@RequestMapping("/api/estado")
public class EstadoController {

    @Autowired // inj de dependencia, pra não criar new estadoService
    private EstadoService estService;

    @GetMapping("/")
    public List<Estado> buscarTodos() {
        return estService.buscarTodos();
    }

    @PostMapping("/")
    public Estado inserir(@RequestBody Estado estado) {
        return estService.inserir(estado);
    }

    @PutMapping("/")
    public Estado alterar(@RequestBody Estado estado) {
        return estService.alterar(estado);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        estService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
