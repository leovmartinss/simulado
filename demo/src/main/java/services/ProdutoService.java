package services;

import entities.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.ProdutoRepository;

import java.util.List;


@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarProdutos(){
    return produtoRepository.findAll();
    }

    public Produto adicionar(Produto produto){
        return produtoRepository.save(produto);
    }
    public Produto consultarId (long id) {
        return produtoRepository.findById(id).orElse(null);
    }
}



