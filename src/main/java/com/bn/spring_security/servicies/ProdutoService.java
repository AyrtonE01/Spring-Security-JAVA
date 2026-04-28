package com.bn.spring_security.servicies;

import com.bn.spring_security.controllers.ProdutoController;
import com.bn.spring_security.entities.ProdutoEntity;
import com.bn.spring_security.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public ProdutoEntity salvar(ProdutoEntity produto) {
        return repository.save(produto);
    }

    public List<ProdutoEntity> listarTodos() {
        return repository.findAll();
    }

    public Optional<ProdutoEntity> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}