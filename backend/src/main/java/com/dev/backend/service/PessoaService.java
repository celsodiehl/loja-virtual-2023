package com.dev.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Pessoa;
import com.dev.backend.repository.PessoaRepository;

@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository repository;

    public List<Pessoa> buscarTodos() {
        return repository.findAll();
    }

        // O Repository verifica se tem ID ou não e dai cria ou altera
        public Pessoa inserir(Pessoa obj) {
            Pessoa novo = repository.saveAndFlush(obj);
            return novo;
        }
    
        public Pessoa alterar(Pessoa obj) {
            return repository.saveAndFlush(obj);
        }
    
        public void excluir(Long id) {
            // Retorna Optional, dai colóca um get
            Pessoa obj = repository.findById(id).get();
            repository.delete(obj);
        }
}