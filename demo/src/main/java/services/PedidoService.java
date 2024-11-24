package services;

import entities.Pedido;
import entities.Produto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.PedidoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRespository;

    public List<Pedido> listarTodos(){
        return pedidoRespository.findAll();
    }

    public Pedido adicionar (Pedido pedido){
        return pedidoRespository.save(pedido);
    }

    public Pedido alterar(Long id, Pedido pedido){
        if (pedidoRespository.existsById(id)) {
            pedido.setId(id);
            return pedidoRespository.save(pedido);
        }
        return null;
    }

    public void remove(Long id){
        pedidoRespository.deleteById(id);
    }

    public Pedido alterarProduto(Long id, List<Produto> produtos) {
        if (produtos == null || produtos.isEmpty()) {
            throw new IllegalArgumentException("A lista de produtos não pode ser vazia.");
        }
        Optional<Pedido> pedidoOptional = pedidoRespository.findById(id);

        if (pedidoOptional.isEmpty()) {
            throw new EntityNotFoundException("Pedido não encontrado: " + id);
        }
        Pedido pedido = pedidoOptional.get();
        pedido.setProdutos(produtos);
        return pedidoRespository.save(pedido);
    }

}