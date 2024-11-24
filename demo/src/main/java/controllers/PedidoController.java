package controllers;

import entities.Pedido;
import entities.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.PedidoService;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> listarTodos() {
        return pedidoService.listarTodos();
    }

    @PostMapping
    public Pedido adicionar(@RequestBody Pedido pedido) {
        return pedidoService.adicionar(pedido);
    }

    @PutMapping("/{id}/produtos")
    public Pedido alterarProdutos(@PathVariable Long id, @RequestBody List<Produto> produtos){
        return pedidoService.alterarProduto(id,produtos);

    }

    @DeleteMapping("/{id}")
    public void remove (@PathVariable Long id){
        pedidoService.remove(id);
    }


}
