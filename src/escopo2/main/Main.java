package escopo2.main;


import escopo2.model.Estoque;
import escopo2.model.Produto;

public class Main {
    public static void main(String[] args) {
        Produto produto1 = new Produto(
                "Camisa",
                "Cor azul",
                35,
                10
        );

        Produto produto2 = new Produto(
                "Calça",
                "Cor branca",
                55,
                3
        );

        Estoque estoque = new Estoque();

        estoque.adicionarProduto(produto1);
        estoque.adicionarProduto(produto2);
        estoque.gerarRelatorio();
    }
}