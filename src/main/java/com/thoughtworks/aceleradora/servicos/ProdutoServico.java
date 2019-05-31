package com.thoughtworks.aceleradora.servicos;


import com.thoughtworks.aceleradora.dominio.Produto;
import com.thoughtworks.aceleradora.repositorios.ProdutoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServico {

    private ProdutoRepositorio repositorio;

    public ProdutoServico(ProdutoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Produto> pegarTodos() {
        return repositorio.findAll();
    }

    public Produto salvar(Produto produto) {
            return repositorio.save(produto);
    }

    public Produto encontraUm(Long id) {
        Optional<Produto> produto = repositorio.findById(id);
        return produto.get();
    }

    public boolean removerTodos(List<Produto> produtosDoBanco, List<Produto> produtosParaSeremRemovidos) {
        try {
            if(produtosParaSeremRemovidos.isEmpty()) return true;
            return produtosDoBanco.removeAll(produtosParaSeremRemovidos);

        } catch (Exception e) {
            return false;
        }
    }
}
