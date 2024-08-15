package escopo3.model;

import java.util.UUID;

public class Passageiro {
    public final UUID id;
    public final String nome;
    public final String email;
    public final Reserva[] listaDeReservas;

    public Passageiro(String nome, String email) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.email = email;
        this.listaDeReservas = new Reserva[5];
    }

    public boolean temEspacoNaLista() {
        for (int i = 0; i < this.listaDeReservas.length; i++) {
            if (this.listaDeReservas[i] == null) {
                return true;
            }
        }
        return false;
    }

    public void adicionarReserva(Reserva reserva) {
        for (int i = 0; i < this.listaDeReservas.length; i++) {
            if (this.listaDeReservas[i] == null) {
                this.listaDeReservas[i] = reserva;
                System.out.printf("Reserva feita com sucesso para \"%s\"\n", this.nome);
                return;
            }
        }
        System.out.println("Não foi possivel fazer a reserva");
    }

    public void removerReserva(Reserva reserva) {
        for (int i = 0; i < this.listaDeReservas.length; i++) {
            if (this.listaDeReservas[i] != null && this.listaDeReservas[i] == reserva) {
                this.listaDeReservas[i] = null;
                System.out.printf("Reserva removida com sucesso de \"%s\"\n", this.nome);
                return;
            }
        }
        System.out.println("Reserva não encontrada");
    }

    public void exibirInfo() {
        System.out.println("Passageiro Info");
        System.out.printf("Nome: %s\n", this.nome);
        System.out.printf("E-mail: %s\n", this.email);
        System.out.println("Reservas: ");
        for (int i = 0; i < this.listaDeReservas.length; i++) {
            if (this.listaDeReservas[i] != null) {
                this.listaDeReservas[i].exibirInfo();
            }
        }
        System.out.println();
    }

    /*Atributos:
        Nome
        ID
        E-mail
        Reservas (uma lista de objetos de reserva, com limite de reservas por passageiro)
    Métodos:
        exibirInfo(): Exibe informações detalhadas sobre o passageiro.
    */
}
