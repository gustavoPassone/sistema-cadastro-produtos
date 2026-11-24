package test;

import dominio.Produto;

public class ProdutoTest01 {
    public static void main(String[] args) {
        Produto produto01 = new Produto();
        Produto produto02 = new Produto();

        produto01.setNome("Teclado");
        produto01.setPreco(150.00);
        produto01.setQuantidade(5);

        produto02.setNome("Mouse");
        produto02.setPreco(80.00);
        produto02.setQuantidade(10);

        exibirProduto("PRODUTO 01", produto01);
        System.out.println();
        exibirProduto("PRODUTO 02", produto02);

        System.out.println("\n========== TESTANDO VALIDACOES ==========");
        produto01.setPreco(-500);
        produto02.setQuantidade(-10);
        produto01.setNome("   ");

        System.out.println("Preço do Teclado após tentativa inválida: R$ " + produto01.getPreco());
        System.out.println("Quantidade do Mouse após tentativa inválida: " + produto02.getQuantidade());

        // Tentativa de acesso direto a atributo privado (gera erro de compilação):
        // produto01.preco = 500;

        System.out.println("\n========== DESAFIO EXTRA: ADICIONAR ESTOQUE ==========");
        produto01.adicionarEstoque(3);
        System.out.println("Nova quantidade de " + produto01.getNome() + ": " + produto01.getQuantidade());
        System.out.println("Novo valor do estoque: R$ " + produto01.calcularValorEstoque());
    }

    private static void exibirProduto(String titulo, Produto produto) {
        System.out.println("========== " + titulo + " ==========");
        System.out.println("Nome: " + produto.getNome());
        System.out.println("Preço: R$ " + produto.getPreco());
        System.out.println("Quantidade: " + produto.getQuantidade());
        System.out.println("Valor do estoque: R$ " + produto.calcularValorEstoque());
    }
}
