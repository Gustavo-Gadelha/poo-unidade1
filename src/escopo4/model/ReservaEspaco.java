package escopo4.model;

import java.time.LocalDate;

public class ReservaEspaco {
    public final Organizador organizador;
    public final Evento evento;
    public final LocalDate dataDaReserva;
    public final String locaReservado;

    public ReservaEspaco(Organizador organizador, Evento evento) {
        this.organizador = organizador;
        this.evento = evento;
        this.dataDaReserva = LocalDate.now();
        this.locaReservado = evento.local;
    }

    public void exibirInfo() {
        System.out.println("|========= Reserva Info =========|");
        System.out.printf("Reserva feita por: %s\n", this.organizador.nome);
        System.out.printf("Nome do evento reservado: %s\n", this.evento.nome);
        System.out.printf("Data da reserva: %s\n", this.dataDaReserva);
        System.out.printf("Local reservado: %s\n\n", this.locaReservado);
    }

    /*
    Atributos:
        Organizador (referência ao organizador que fez a reserva)
        Evento (referência ao evento reservado)
        Data da Reserva
        Espaço Reservado (indicando o local reservado para o evento)
    Métodos:
        exibirInfo(): Exibe informações detalhadas sobre a reserva de espaço.
    */

}
