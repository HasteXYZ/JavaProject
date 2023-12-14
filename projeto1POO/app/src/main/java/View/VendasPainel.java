package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VendasPainel extends JPanel {
    private JPanel painelPrincipal, painelVenda;
    private JLabel labelCodigo, labelQuantidade, labelTotal;
    private JTextField campoCodigo, campoQuantidade;
    private JButton botaoAdicionar, botaoFinalizar;
    private JTable tabelaVenda;
    private DefaultTableModel modeloVenda;
    private JScrollPane scrollVenda;

    public VendasPainel() {
        painelPrincipal = new JPanel();
        painelPrincipal.setBounds(0, 0, 800, 800);
        add(painelPrincipal);

        painelVenda = new JPanel();
        painelVenda.setBounds(10, 100, 780, 250);
        painelVenda.setBorder(BorderFactory.createTitledBorder("Venda"));
        painelPrincipal.add(painelVenda);

        labelCodigo = new JLabel("Código:");
        labelCodigo.setBounds(10, 20, 50, 30);
        painelVenda.add(labelCodigo);

        campoCodigo = new JTextField();
        campoCodigo.setBounds(60, 20, 100, 30);
        painelVenda.add(campoCodigo);

        labelQuantidade = new JLabel("Quantidade:");
        labelQuantidade.setBounds(170, 20, 80, 30);
        painelVenda.add(labelQuantidade);

        campoQuantidade = new JTextField();
        campoQuantidade.setBounds(250, 20, 50, 30);
        painelVenda.add(campoQuantidade);

        botaoAdicionar = new JButton("Adicionar");
        botaoAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Código para executar quando o botão é pressionado
            }
        });
        painelVenda.add(botaoAdicionar);

        botaoFinalizar = new JButton("Finalizar");
        botaoFinalizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Código para executar quando o botão é pressionado
            }
        });
        painelVenda.add(botaoFinalizar);

        labelTotal = new JLabel("Total: R$ 0.00");
        labelTotal.setBounds(530, 20, 100, 30);
        labelTotal.setHorizontalAlignment(SwingConstants.RIGHT);
        painelVenda.add(labelTotal);

        modeloVenda = new DefaultTableModel();
        modeloVenda.addColumn("Código");
        modeloVenda.addColumn("Descrição");
        modeloVenda.addColumn("Quantidade");
        modeloVenda.addColumn("Preço");
        modeloVenda.addColumn("Subtotal");

        tabelaVenda = new JTable(modeloVenda);
        tabelaVenda.getColumnModel().getColumn(0).setPreferredWidth(50);
        tabelaVenda.getColumnModel().getColumn(1).setPreferredWidth(300);
        tabelaVenda.getColumnModel().getColumn(2).setPreferredWidth(50);
        tabelaVenda.getColumnModel().getColumn(3).setPreferredWidth(50);
        tabelaVenda.getColumnModel().getColumn(4).setPreferredWidth(50);
        tabelaVenda.setEnabled(false);

        scrollVenda = new JScrollPane(tabelaVenda);
        scrollVenda.setBounds(10, 60, 760, 180);
        painelVenda.add(scrollVenda);
    }
}
