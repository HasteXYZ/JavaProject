package Connection;

import Model.Produtos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdutosDAO {
    private Connection connection;

    public List<Produtos> listarProdutos() {
        List<Produtos> produtos = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM produtos");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                double preco = resultSet.getDouble("preco");
                produtos.add(new Produtos(id, nome, preco));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar produtos: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return produtos;
    }

    public void adicionarProduto(Produtos produto) {
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO produtos (id, nome, preco) VALUES (?, ?, ?)");
            statement.setInt(1, produto.getId());
            statement.setString(2, produto.getNome());
            statement.setDouble(3, produto.getPreco());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar produto: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }
    
    public void criaTabelaProdutos() {
        String sql = "CREATE TABLE IF NOT EXISTS produtos (ID SERIAL PRIMARY KEY, NOME VARCHAR(255), PRECO DOUBLE PRECISION)";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela de produtos criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela de produtos: " + e.getMessage(), e);
        } finally {
            DatabaseConnection.closeConnection(this.connection);
        }
    }

}
