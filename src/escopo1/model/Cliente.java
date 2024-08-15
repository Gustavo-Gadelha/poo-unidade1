package escopo1.model;

import java.util.UUID;

public class Cliente {
    public final UUID id;
    public final String nome;
    public final String email;
    public final Reserva[] reservas;

    public Cliente(String nome, String email) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.email = email;
        this.reservas = new Reserva[4];
    }

    public boolean temEspacoParaReservas() {
        for (int i = 0; i < this.reservas.length; i++) {
            if (this.reservas[i] != null) {
                return true;
            }
        }
        return false;
    }

    public void adicionarReserva(Reserva reserva) {
        for (int i = 0; i < this.reservas.length; i++) {
            if (this.reservas[i] == null) {
                this.reservas[i] = reserva;
            }
        }
    }

    public void removerReserva(int numeroDoQuarto) {
        for (int i = 0; i < this.reservas.length; i++) {
            if (this.reservas[i].quarto.numero == numeroDoQuarto) {
                this.reservas[i] = null;
            }
        }
    }

    public boolean verificarReserva(int numeroDoQuarto) {
        for (int i = 0; i < this.reservas.length; i++) {
            if (this.reservas[i].quarto.numero == numeroDoQuarto) {
                return true;
            }
        }
        return false;
    }

    public void exibirInfo() {
        System.out.println("Cliente Info");
        System.out.printf("Nome do cliente: %s\n", this.nome);
        System.out.printf("email do cliente: %s\n", this.email);
        System.out.println("Reservas do cliente: ");
    }

    /*
    Atributos:
        Nome
        ID
        E-mail
        Reservas (uma lista de objetos de reserva, com limite de reservas por cliente)
    Métodos:
        exibirInfo(): Exibe informações detalhadas sobre o usuário
    */

}
