package com.dev.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Produto;
import com.dev.backend.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository repository;

    public List<Produto> buscarTodos() {
        return repository.findAll();
    }

        // O Repository verifica se tem ID ou não e dai cria ou altera
        public Produto inserir(Produto obj) {
            Produto novo = repository.saveAndFlush(obj);
            return novo;
        }
    
        public Produto alterar(Produto obj) {
            return repository.saveAndFlush(obj);
        }
    
        public void excluir(Long id) {
            // Retorna Optional, dai colóca um get
            Produto obj = repository.findById(id).get();
            repository.delete(obj);
        }
}