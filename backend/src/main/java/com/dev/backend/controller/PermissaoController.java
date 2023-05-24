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

import com.dev.backend.entity.Permissao;
import com.dev.backend.service.PermissaoService;

//Responde a requisições tipo Rest
@RestController
@RequestMapping("/api/permissao")
public class PermissaoController {
    
    @Autowired // inj de dependencia, pra não criar new estadoService
    private PermissaoService service;

    @GetMapping("/")
    public List<Permissao> buscarTodos() {
        return service.buscarTodos();
    }

    @PostMapping("/")
    public Permissao inserir(@RequestBody Permissao obj) {
        return service.inserir(obj);
    }

    @PutMapping("/")
    public Permissao alterar(@RequestBody Permissao obj) {
        return service.alterar(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        service.excluir(id);
        return ResponseEntity.ok().build();
    }

}
