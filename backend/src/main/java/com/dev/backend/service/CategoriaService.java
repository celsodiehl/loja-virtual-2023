package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Categoria;
import com.dev.backend.repository.CategoriaRepository;

@Service
public class CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> buscarTodos() {
        return categoriaRepository.findAll();
    }

        // O Repository verifica se tem ID ou não e dai cria ou altera
        public Categoria inserir(Categoria categoria) {
            Categoria categoriaNovo = categoriaRepository.saveAndFlush(categoria);
            return categoriaNovo;
        }
    
        public Categoria alterar(Categoria categoria) {
            return categoriaRepository.saveAndFlush(categoria);
        }
    
        public void excluir(Long id) {
            // Retorna Optional, dai colóca um get
            Categoria categoria = categoriaRepository.findById(id).get();
            categoriaRepository.delete(categoria);
        }
}
