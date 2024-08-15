package escopo2.model;

import java.util.Scanner;

public class Estoque {
    public final Produto[] produtos = new Produto[30];

    public boolean verificarDisponibilidade() {
        for (int i = 0; i < this.produtos.length; i++) {
            if (this.produtos[i] == null) {
                return true;
            }
        }
        return false;
    }

    public Produto buscarProduto(Produto produto) {
        for (int i = 0; i < this.produtos.length; i++) {
            if (this.produtos[i] == produto) {
                return this.produtos[i];
            }
        }
        return null;
    }

    public void adicionarProduto(Produto produto) {
        if (!this.verificarDisponibilidade()) {
            System.out.println("Não é possível adicionar mais produtos");
        } else if (this.buscarProduto(produto) != null) {
            System.out.println("Esse produto já está cadastrado no estoque");
        } else {
            for (int i = 0; i < this.produtos.length; i++) {
                if (this.produtos[i] == null) {
                    this.produtos[i] = produto;
                    return;
                }
            }
        }
    }

    public void atualizarProduto(Produto produto, String atributo) {
        if (this.buscarProduto(produto) == null) {
            System.out.println("Este produto não está no estoque");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        switch (atributo.toLowerCase()) {
            case "nome" -> produto.nome = scanner.nextLine();
            case "descrição" -> produto.descricao = scanner.nextLine();
            case "preço" -> produto.preco = scanner.nextDouble();
            case "quantidade" -> produto.quantidade = scanner.nextInt();
            default -> System.out.println("Atributo Inválido");
        }

        scanner.close();
    }

    public void removerProduto(Produto produto) {
        if (this.buscarProduto(produto) == null) {
            System.out.println("Este produto não está no estoque");
            return;
        }

        for (int i = 0; i < this.produtos.length; i++) {
            if (this.produtos[i] == produto) {
                this.produtos[i] = null;
            }
        }
    }

    public void gerarRelatorio() {
        System.out.println("Relatório dos produtos em estoque:");
        for (int i = 0; i < this.produtos.length; i++) {
            if (this.produtos[i] != null) {
                this.produtos[i].exibirInfo();
            }
        }
        System.out.println();
    }

    /*
    Atributos:
        Lista de Produtos em Estoque (Com limite)
    Métodos:
        verificarDisponibilidade(): Verifica a disponibilidade de produtos em estoque.
        adicionarProduto(): Permite adicionar um novo produto ao estoque.
        atualizarProduto(): Permite atualizar as informações de um produto existente.
        excluirProduto(): Permite excluir um produto do estoque.
        gerarRelatorio(): Gera um relatório com informações sobre os produtos em estoque.
    */

}
