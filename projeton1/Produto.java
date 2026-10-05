public class Produto {

    private String nome;
    private double preco;
    private StatusProduto status;

    public Produto(String nome, double preco, StatusProduto status) {
        this.nome = nome;
        this.preco = preco;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public StatusProduto getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
               " | Preço: R$ " + preco +
               " | Status: " + status;
    }
}