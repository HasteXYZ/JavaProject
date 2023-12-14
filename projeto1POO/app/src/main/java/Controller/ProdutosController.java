package Controller;

import Model.Produtos;

import java.util.ArrayList;
import java.util.List;

public class ProdutosController {
    private List<Produtos> produtos;

    public ProdutosController() {
        produtos = new ArrayList<>();
        produtos.add(new Produtos(1, "Produto 1", 19.99));
        produtos.add(new Produtos(2, "Produto 2", 29.99));
    }

    public List<Produtos> listarProdutos() {
        return produtos;
    }

    public void adicionarProduto(Produtos produto) {
        if (produto != null) {
            produtos.add(produto);
        } else {
            throw new IllegalArgumentException("Produto inválido");
        }
    }
}
