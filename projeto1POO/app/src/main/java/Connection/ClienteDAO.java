package Connection;

import Model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    // atributo
    private Connection connection;

    // construtor
    public ClienteDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    // criar tabela
    public void criaTabelaClientes() {
        String sql = "CREATE TABLE IF NOT EXISTS clientes (CPF VARCHAR(255) PRIMARY KEY, NOME VARCHAR(255), IDADE VARCHAR(255))";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela de clientes criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela de clientes: " + e.getMessage(), e);
        } finally {
            DatabaseConnection.closeConnection(this.connection);
        }
    }

    // listar clientes
    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM cadastrousuario");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String cpf = resultSet.getString("cpf");
                String nome = resultSet.getString("nome");
                String idade = resultSet.getString("idade");
                clientes.add(new Cliente(cpf, nome, idade));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar clientes: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return clientes;
    }

    // adicionar cliente
    public void adicionarCliente(Cliente cliente) {
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO cadastrousuario (cpf, nome, idade) VALUES (?, ?, ?)");
            statement.setString(1, cliente.getCpf());
            statement.setString(2, cliente.getNome());
            statement.setString(3, cliente.getIdade());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar cliente: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

   // cadastrar cliente
public void cadastrar(String cpf, String nome, String idade) {
    PreparedStatement stmt = null;
    // Define a instrução SQL parametrizada para cadastrar na tabela
    String sql = "INSERT INTO cadastrousuario (cpf, nome, idade) VALUES (?, ?, ?)";
    try {
        stmt = connection.prepareStatement(sql);

        stmt.setString(1, cpf);
        stmt.setString(2, nome);
        stmt.setString(3, idade);
        stmt.executeUpdate();
        System.out.println("Dados inseridos com sucesso");
    } catch (SQLException e) {
        throw new RuntimeException("Erro ao inserir dados no banco de dados.", e);
    } finally {
        DatabaseConnection.closeConnection(null, stmt); // Alterado para fechar apenas o statement
    }
}


    // atualizar dados do cliente
    public void atualizar(String cpf, String nome, String idade) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para atualizar dados pelo CPF
        String sql = "UPDATE cadastrousuario SET nome = ?, idade = ? WHERE cpf = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, idade);
            stmt.setString(3, cpf);
            stmt.executeUpdate();
            System.out.println("Dados atualizados com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar dados no banco de dados.", e);
        } finally {
            DatabaseConnection.closeConnection(null, stmt); // Alterado para fechar apenas o statement
        }
    }
}
