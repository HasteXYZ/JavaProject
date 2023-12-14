package Connection;

import Model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {
    private Connection connection;

    public List<Venda> listarVendas() {
        List<Venda> vendas = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM vendas");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String cpf = resultSet.getString("cpf");
                String id = resultSet.getString("id");
                String datahora = resultSet.getString("datahora");
                String total = resultSet.getString("total");
                vendas.add(new Venda(cpf, id, datahora, total));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar vendas: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return vendas;
    }

    public void adicionarVenda(Venda venda) {
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO vendas (cpf, id, datahora, total) VALUES (?, ?, ?, ?)");
            statement.setString(1, venda.getCpf());
            statement.setString(2, venda.getId());
            statement.setString(3, venda.getDatahora());
            statement.setString(4, venda.getTotal());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar venda: " + e.getMessage());
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    public void criaTabelaVendas() {
        String sql = "CREATE TABLE IF NOT EXISTS vendas (CPF_CLIENTE VARCHAR(255), ID_PRODUTO INTEGER, DATAHORA VARCHAR(255), QUANTIDADE INTEGER, TOTAL DOUBLE PRECISION, FOREIGN KEY (CPF_CLIENTE) REFERENCES clientes(CPF), FOREIGN KEY (ID_PRODUTO) REFERENCES produtos(ID))";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela de vendas criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela de vendas: " + e.getMessage(), e);
        } finally {
            DatabaseConnection.closeConnection(this.connection);
        }
    }

}
