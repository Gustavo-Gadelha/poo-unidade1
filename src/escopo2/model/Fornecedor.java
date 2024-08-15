package escopo2.model;

public class Fornecedor {
    public final String nome;
    public final String cnpj;
    public final Produto[] produtos;

    public Fornecedor(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.produtos = new Produto[10];
    }

    public void exibirInfo() {
        System.out.println("Fornecedor Info");
        System.out.printf("Nome do fornecedor: %s\n", this.nome);
        System.out.printf("CNPJ do fornecedor: %s\n", this.cnpj);
        System.out.println("Lista de Produtos: ");
        for (int i = 0; i < this.produtos.length; i++) {
            if (this.produtos[i] != null) {
                this.produtos[i].exibirInfo();
            }
        }
        System.out.println();
    }

    /*
    Atributos:
        Nome
        CNPJ
        Lista de Produtos Fornecidos (uma lista de objetos de produto, com limite de produtos por fornecedor)
    Métodos:
        exibirInfo(): Exibe informações detalhadas sobre o fornecedor.
    */
}
