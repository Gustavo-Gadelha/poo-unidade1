package escopo1.model;

public class Quarto {
    public final int numero;
    public final String tipo;
    public final double precoPorNoite;
    public boolean disponivel;

    public Quarto(int numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
        this.precoPorNoite = this.calcularPreco(tipo);
        this.disponivel = true;
    }

    public double calcularPreco(String tipo) {
        return switch (tipo.toLowerCase()) {
            case "suite" -> 100;
            case "duplo" -> 70;
            default -> 30;
        };
    }

    public void exibirInfo() {
        System.out.println("Quarto Info");
        System.out.printf("Número do quarto: %d\n", this.numero);
        System.out.printf("Tipo de Quarto: %s\n", this.tipo);
        System.out.printf("Preço por Noite: %f\n", this.precoPorNoite);
        System.out.printf("Disponível: %b\n", this.disponivel);
    }

    public static Quarto[] criarQuartos(int quantidadeDeQuartos) {
        Quarto[] listaDeQuartos = new Quarto[quantidadeDeQuartos];
        for (int i = 0; i < listaDeQuartos.length; i++) {
            listaDeQuartos[i] = new Quarto(i, "simples");
        }
        return listaDeQuartos;
    }

    /*
    Atributos:
        Número do Quarto
        Tipo de Quarto (simples, duplo, suíte, etc.)
        Preço por Noite
        Disponibilidade (indicando se o quarto está ocupado ou disponível).
    Métodos:
        exibirInfo(): Exibe informações detalhadas sobre o usuário
    */

}
