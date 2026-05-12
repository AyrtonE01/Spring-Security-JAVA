package com.bn.spring_security.controllers;

import com.bn.spring_security.entities.ProdutoEntity;
import com.bn.spring_security.servicies.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;

@RestController
@RequestMapping(path = "/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping
    public ProdutoEntity criar(@RequestBody ProdutoEntity produto) {
        return service.salvar(produto);
    }

    @GetMapping
    public List<ProdutoEntity> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<ProdutoEntity> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}