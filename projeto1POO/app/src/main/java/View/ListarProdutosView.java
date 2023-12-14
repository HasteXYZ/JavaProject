package View;

import Model.Produtos;

import java.util.List;

public class ListarProdutosView {

    public void mostrarProdutos(List<Produtos> produtos) {
        for (Produtos produto : produtos) {
            System.out.println("ID: " + produto.getId() + ", Nome: " + produto.getNome() + ", Preço: " + produto.getPreco());
        }
    }
}
