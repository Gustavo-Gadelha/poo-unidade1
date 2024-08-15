package escopo2.model;

import java.util.UUID;

public class GestorProdutos {
    public final Fornecedor[] fornecedores = new Fornecedor[10];

    public void cadastrarFornecedor(Fornecedor fornecedor) {
        for (int i = 0; i < this.fornecedores.length; i++) {
            if (this.fornecedores[i] == null) {
                this.fornecedores[i] = fornecedor;
            }
        }
        System.out.println("Não é possível cadastrar mais fornecedores");
    }

    public Produto buscarProdutoPorNome(String nome) {
        for (int i = 0; i < this.fornecedores.length; i++) {
            if (this.fornecedores[i] == null) continue;
            for (int in = 0; in < this.fornecedores[i].produtos.length; in++) {
                if (this.fornecedores[i].produtos[in] != null && this.fornecedores[i].produtos[in].nome.equals(nome)) {
                    return this.fornecedores[i].produtos[in];
                }
            }
        }
        System.out.println("Produto não encontrado");
        return null;
    }

    public Produto buscarProdutoPorID(UUID id) {
        for (int i = 0; i < this.fornecedores.length; i++) {
            if (this.fornecedores[i] == null) continue;
            for (int in = 0; in < this.fornecedores[i].produtos.length; in++) {
                if (this.fornecedores[i].produtos[in] != null && this.fornecedores[i].produtos[in].id.equals(id)) {
                    return this.fornecedores[i].produtos[in];
                }
            }
        }
        System.out.println("Produto não encontrado");
        return null;
    }

    public void exibirInfoFornecedor() {
        for (int i = 0; i < this.fornecedores.length; i++) {
            if (this.fornecedores[i] != null) {
                this.fornecedores[i].exibirInfo();
            }
        }
    }

    public void exibirInfoProduto() {
        for (int i = 0; i < this.fornecedores.length; i++) {
            if (this.fornecedores[i] == null) continue;
            for (int in = 0; in < this.fornecedores[i].produtos.length; in++) {
                if (this.fornecedores[i].produtos[in] != null) {
                    this.fornecedores[i].produtos[in].exibirInfo();
                }
            }
        }
    }

    /*
    Atributos:
        Lista de Fornecedores (limite de fornecedores)
    Métodos:
        cadastrarFornecedor(): Permite cadastrar um novo fornecedor.
        buscarProdutoPorNome(): Permite a busca de produtos por nome.
        buscarProdutoPorID(): Permite a busca de produtos por ID.
        exibirInfoFornecedor(): Exibe informações detalhadas sobre o fornecedor.
        exibirInfoProduto(): Exibe informações detalhadas sobre o produto.
    */
}
