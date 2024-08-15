package escopo1.model;

import java.time.LocalDate;

public class Hotel {
    public final String nome;
    public final String endereco;
    public final Quarto[] quartos;

    public Hotel(String nome, String endereco, int quantidadeDeQuartos) {
        this.nome = nome;
        this.endereco = endereco;
        this.quartos = Quarto.criarQuartos(quantidadeDeQuartos);
    }

    public boolean verificarDisponibilidade() {
        for (int i = 0; i < this.quartos.length; i++) {
            if (this.quartos[i].disponivel) {
                return true;
            }
        }
        return false;
    }

    public void fazerReserva(Cliente cliente, int numeroDoQuarto, LocalDate checkIn, LocalDate checkOut) {
        if (!this.verificarDisponibilidade()) {
            System.out.println("Não há mais nenhum quarto disponível");
            return;
        }

        if (numeroDoQuarto > this.quartos.length) {
            System.out.println("Este quarto não existe");
        } else if (!this.quartos[numeroDoQuarto].disponivel) {
            System.out.println("Quarto já reservado!");
        } else if (!cliente.temEspacoParaReservas()) {
            System.out.println("Este cliente não pode fazer mais reservas!");
        } else {
            Reserva reserva = new Reserva(cliente, this.quartos[numeroDoQuarto], checkIn, checkOut);
            cliente.adicionarReserva(reserva);
        }
    }

    public void cancelarReserva(Cliente cliente, int numeroDoQuarto) {
        if (!cliente.verificarReserva(numeroDoQuarto)) {
            System.out.println("Este cliente não reservou este quarto");
        } else {
            cliente.removerReserva(numeroDoQuarto);
            this.quartos[numeroDoQuarto].disponivel = true;
        }
    }

    public Quarto localizarQuartoPorTipo(String tipo) {
        for (int i = 0; i < this.quartos.length; i++) {
            if (this.quartos[i].tipo.equals(tipo)) {
                return this.quartos[i];
            }
        }
        return null;
    }

    public void exibirInfo() {
        System.out.println("Hotel Info");
        System.out.printf("Nome do hotel: %s\n", this.nome);
        System.out.printf("Endereço do hotel: %s\n", this.endereco);
        System.out.printf("Número de quartos: %d\n", this.quartos.length);
        System.out.println("Quartos");
        for (int i = 0; i < this.quartos.length; i++) {
            this.quartos[i].exibirInfo();
        }
    }

    /*
    Atributos:
        Nome
        Endereço
        Lista de Quartos (limite de quartos disponíveis)
    Métodos:
        verificarDisponibilidade(): Verifica se há pelo menos um quarto disponível para reserva.
        fazerReserva(): Permite aos clientes fazerem uma reserva de quarto, marcando o quarto como ocupado e associando-o ao cliente.
        cancelarReserva(): Permite aos clientes cancelarem uma reserva, marcando o quarto como disponível novamente.
        localizarQuartoPorTipo(): Permite a busca de quartos disponíveis por tipo (simples, duplo, suíte, etc.).
        exibirInfo(): Exibe informações detalhadas sobre o hotel, incluindo a lista de quartos e clientes.
    */

}
