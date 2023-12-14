package Controller;

import Model.Venda;

import java.util.ArrayList;
import java.util.List;

public class VendasController {
    private List<Venda> vendas;

    public VendasController() {
        vendas = new ArrayList<>();
    }

    public void adicionarVenda(Venda venda) {
        if (venda != null) {
            vendas.add(venda);
        } else {
            throw new IllegalArgumentException("Venda inválida");
        }
    }
}
