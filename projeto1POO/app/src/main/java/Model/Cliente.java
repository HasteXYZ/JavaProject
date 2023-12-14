package Model;

public class Cliente {
    private String cpf;
    private String nome;
    private String idade;

    public Cliente(String cpf, String nome, String idade) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf != null && !cpf.isEmpty()) {
            this.cpf = cpf;
        } else {
            throw new IllegalArgumentException("CPF inválido");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("Nome inválido");
        }
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        if (idade != null && !idade.isEmpty()) {
            this.idade = idade;
        } else {
            throw new IllegalArgumentException("Idade inválida");
        }
    }
}
