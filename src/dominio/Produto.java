package dominio;

public class Produto {
    private String nome;
    private double preco;
    private int quantidade;
    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            System.out.println("Erro: o nome do produto não pode ser vazio.");
            return;
        }
        this.nome = nome;
    }

    public void setPreco(double preco) {
        if (preco < 0 || Double.isNaN(preco)) {
            System.out.println("Erro: o preço não pode ser negativo.");
            return;
        }
        this.preco = preco;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade < 0) {
            System.out.println("Erro: a quantidade não pode ser negativa.");
            return;
        }
        this.quantidade = quantidade;
    }

    public String getNome() {
        return this.nome;
    }

    public double getPreco() {
        return this.preco;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public double calcularValorEstoque() {
        return this.preco * this.quantidade;
    }

    public void adicionarEstoque(int quantidade) {
        if (quantidade <= 0) {
            System.out.println("Erro: a quantidade a adicionar deve ser positiva.");
            return;
        }
        this.quantidade += quantidade;
    }
}
