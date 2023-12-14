// 4. Classe ProdutosController (Controller)
public class ProdutosController {
    // ...
    public void adicionarProduto(Produtos produto) {
        if (produto != null) {
            produtos.add(produto);
        } else {
            throw new IllegalArgumentException("Produto inválido");
        }
    }
    // ...
}








// 5. Classe VendasController (Controller)
public class VendasController {
    // ...
    public void adicionarVenda(Venda venda) {
        if (venda != null) {
            vendas.add(venda);
        } else {
            throw new IllegalArgumentException("Venda inválida");
        }
    }
    // ...
}







// 11. Classe VendasPainel (View)
public class VendasPainel extends JPanel {
    // ...
    botaoCadastrar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            cadastrarCliente();
        }

        private void cadastrarCliente() {
            String cpf = campoCliente.getText();
            // Aqui você pode adicionar a lógica para cadastrar um cliente
            // Por exemplo, você pode criar um novo objeto Cliente e adicioná-lo a uma lista de clientes
        }
    });

    botaoBuscar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            buscarCliente();
        }

        private void buscarCliente() {
            String cpf = campoCliente.getText();
            // Aqui você pode adicionar a lógica para buscar um cliente
            // Por exemplo, você pode percorrer sua lista de clientes e encontrar o cliente com o CPF correspondente
        }
    });

    botaoAdicionar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            adicionarProduto();
        }

        private void adicionarProduto() {
            String codigo = campoCodigo.getText();
            // Aqui você pode adicionar a lógica para adicionar um produto à venda
            // Por exemplo, você pode criar um novo objeto Produto e adicioná-lo a uma lista de produtos da venda
        }
    });

    botaoFinalizar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            finalizarVenda();
        }

        private void finalizarVenda() {
            // Aqui você pode adicionar a lógica para finalizar a venda
            // Por exemplo, você pode calcular o total da venda e exibir uma mensagem de confirmação
        }
    });
    // ...
}
