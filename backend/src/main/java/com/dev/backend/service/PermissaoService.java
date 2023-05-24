package com.dev.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Permissao;
import com.dev.backend.repository.PermissaoRepository;

@Service
public class PermissaoService {
    
    @Autowired
    private PermissaoRepository repository;

    public List<Permissao> buscarTodos() {
        return repository.findAll();
    }

        // O Repository verifica se tem ID ou não e dai cria ou altera
        public Permissao inserir(Permissao obj) {
            Permissao novo = repository.saveAndFlush(obj);
            return novo;
        }
    
        public Permissao alterar(Permissao obj) {
            return repository.saveAndFlush(obj);
        }
    
        public void excluir(Long id) {
            // Retorna Optional, dai colóca um get
            Permissao obj = repository.findById(id).get();
            repository.delete(obj);
        }
}