package View;

import javax.swing.*;

import Connection.ClienteDAO;
import Connection.DatabaseConnection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientePainel extends JPanel {
    private JLabel labelCliente;
    private JTextField campoCliente;
    private JButton botaoBuscar, botaoCadastrar;
    private Connection connection;

    public ClientePainel() {
        labelCliente = new JLabel("Cliente:");
        add(labelCliente);

        campoCliente = new JTextField(20);
        add(campoCliente);

        botaoBuscar = new JButton("Buscar");
        botaoBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarCliente();
            }
        });
        add(botaoBuscar);

        botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastrarCliente();

            }
        });
        add(botaoCadastrar);
    }

        //criar tabela
        public void criaTabela() {
String sql = "CREATE TABLE IF NOT EXISTS cadastrousuario (CPF VARCHAR(255) PRIMARY KEY, NOME VARCHAR(255), IDADE VARCHAR(255))";
    try (Statement stmt = this.connection.createStatement()) {
        stmt.execute(sql);
        System.out.println("Tabela criada com sucesso.");
    } catch (SQLException e) {
        throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e);
    } finally {
        DatabaseConnection.closeConnection(this.connection);
    }
}

    private void buscarCliente() {
        String nomeCliente = campoCliente.getText();
        // Lógica para buscar o cliente com o nome fornecido
        // Exemplo: exibir uma mensagem com o nome do cliente encontrado
        System.out.println("Cliente encontrado: " + nomeCliente);
    }

private void cadastrarCliente() {
    try {
        
        new ClienteDAO().cadastrar("00", null, null);
        campoCliente.setText("");
    } catch (Exception ex) {
        ex.printStackTrace(); // Trate de maneira adequada, como exibir uma mensagem de erro para o usuário.
    }
}

}
