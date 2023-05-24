package com.dev.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.backend.entity.Cidade;
import com.dev.backend.repository.CidadeRepository;

//Regras de negócio
@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public List<Cidade> buscarTodos() {
        return cidadeRepository.findAll();
    }

    // O Repository verifica se tem ID ou não ed ai cria ou altera
    public Cidade inserir(Cidade obj) {
        obj.setDataCriacao(new Date());
        Cidade cidadeNovo = cidadeRepository.saveAndFlush(obj);
        return cidadeNovo;
    }

    public Cidade alterar(Cidade obj) {
        obj.setDataAtualizacao(new Date());
        return cidadeRepository.saveAndFlush(obj);
    }

    public void excluir(Long id) {
        // Retorna Optional, dai colóca um get
        Cidade obj = cidadeRepository.findById(id).get();
        cidadeRepository.delete(obj);
    }

}
