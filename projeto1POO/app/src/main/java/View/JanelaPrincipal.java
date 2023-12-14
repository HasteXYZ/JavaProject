package View;

import javax.swing.*;

public class JanelaPrincipal extends JFrame {
    private JTabbedPane jTPane;

    public JanelaPrincipal() {
        jTPane =  new JTabbedPane();
        add(jTPane);

        VendasPainel tabVendas = new VendasPainel();
        jTPane.add("Vendas", tabVendas);

        ClientePainel tabClientes = new ClientePainel();
        jTPane.add("Clientes", tabClientes);

        ProdutoPainel tabProdutos = new ProdutoPainel();
        jTPane.add("Produtos", tabProdutos);

        setBounds(100, 100, 600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void run() {
        this.setVisible(true);
    }
}
