package escopo3.model;

import java.time.LocalDate;

public class Reserva {
    public final Passageiro passageiro;
    public final Voo voo;
    public final LocalDate dataDaReserva;
    public final int assentosReservados;

    public Reserva(Passageiro passageiro, Voo voo, int assentosReservados) {
        this.passageiro = passageiro;
        this.voo = voo;
        this.dataDaReserva = LocalDate.now();
        this.assentosReservados = assentosReservados;
        passageiro.adicionarReserva(this);
    }

    public void exibirInfo() {
        System.out.println("Reserva Info");
        System.out.printf("Nome do passageiro: %s\n", this.passageiro.nome);
        System.out.printf("Número do voo: %d\n", this.voo.numero);
        System.out.printf("Data da reserva: %d/%d\n", this.dataDaReserva.getDayOfMonth(), this.dataDaReserva.getMonthValue());
        System.out.printf("Assentos reservados: %d\n\n", this.assentosReservados);
    }

    /*
    Atributos:
        Passageiro (referência ao passageiro que fez a reserva)
        Voo (referência ao voo reservado)
        Data da Reserva
        Assentos Reservados (indicando quantos assentos foram reservados nesta reserva)
    Métodos:
        exibirInfo(): Exibe informações detalhadas sobre a reserva.
    */
}
