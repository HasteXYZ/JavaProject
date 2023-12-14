package Model;

public class Venda {
    private String cpf;
    private String id;
    private String datahora;
    private String total;

    public Venda(String cpf, String id, String datahora, String total) {
        this.cpf = cpf;
        this.id = id;
        this.datahora = datahora;
        this.total = total;
    }

    public String getCpf() {
        return cpf;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id != null && !id.isEmpty()) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("ID de venda inválido");
        }
    }

    public String getDatahora() {
        return datahora;
    }

    public void setDatahora(String datahora) {
        if (datahora != null && !datahora.isEmpty()) {
            this.datahora = datahora;
        } else {
            throw new IllegalArgumentException("Data/hora inválida");
        }
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        if (total != null && !total.isEmpty()) {
            this.total = total;
        } else {
            throw new IllegalArgumentException("Total inválido");
        }
    }
}
