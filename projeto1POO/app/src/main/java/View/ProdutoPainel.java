package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProdutoPainel extends JPanel {
    private JLabel labelCodigo, labelQuantidade;
    private JTextField campoCodigo, campoQuantidade;
    private JButton botaoAdicionar;

    public ProdutoPainel() {
        labelCodigo = new JLabel("Código:");
        add(labelCodigo);

        campoCodigo = new JTextField(20);
        add(campoCodigo);

        labelQuantidade = new JLabel("Quantidade:");
        add(labelQuantidade);

        campoQuantidade = new JTextField(20);
        add(campoQuantidade);

        botaoAdicionar = new JButton("Adicionar");
        botaoAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adicionarProduto();
            }
        });
        add(botaoAdicionar);
    }

    private void adicionarProduto() {
        String codigoProduto = campoCodigo.getText();
        String quantidadeProduto = campoQuantidade.getText();

        if (!codigoProduto.isEmpty() && !quantidadeProduto.isEmpty()) {
            try {
                int quantidade = Integer.parseInt(quantidadeProduto);
                System.out.println("Produto adicionado - Código: " + codigoProduto + ", Quantidade: " + quantidade);
            } catch (NumberFormatException ex) {
                System.out.println("Erro: A quantidade deve ser um número inteiro.");
            }
        } else {
            System.out.println("Erro: Preencha todos os campos.");
        }
    }
}
