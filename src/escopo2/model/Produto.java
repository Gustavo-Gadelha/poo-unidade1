package escopo2.model;

import java.util.UUID;

public class Produto {
    public final UUID id;
    public String nome;
    public String descricao;
    public double preco;
    public int quantidade;

    public Produto(String nome, String descricao, double preco, int quantidade) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public void exibirInfo() {
        System.out.println("Produto Info");
        System.out.printf("Nome do produto: %s\n", this.nome);
        System.out.printf("Descrição do produto: %s\n", this.descricao);
        System.out.printf("Preço do produto: R$%.2f\n", this.preco);
        System.out.printf("Quantidade do produto: %d\n\n", this.quantidade);
    }

    /*
    Atributos:
        ID do Produto
        Nome
        Descrição
        Preço
        Quantidade em Estoque
    Métodos:
        exibirInfo(): Exibe informações detalhadas sobre o produto.
    */

}
