class Venda {
    private Cliente cliente;
    private String descricao;
    private double valor;

    public Venda(Cliente cliente, String descricao, double valor) {
        this.cliente = cliente;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }
}