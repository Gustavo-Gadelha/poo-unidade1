package escopo3.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Voo {
    public final int numero;
    public final String origem;
    public final String destino;
    public final LocalDate dataDePartida;
    public final LocalTime horaDePartida;
    public final LocalDate dataDeChegada;
    public final LocalTime horaDeChegada;
    public final int capacidadeDePassageiros;
    public final int assentosReservados;

    public Voo(int numero, String origem, String destino, LocalDate dataDePartida, LocalTime horaDePartida, LocalDate dataDeChegada, LocalTime horaDeChegada, int capacidadeDePassageiros) {
        this.numero = numero;
        this.origem = origem;
        this.destino = destino;
        this.dataDePartida = dataDePartida;
        this.horaDePartida = horaDePartida;
        this.dataDeChegada = dataDeChegada;
        this.horaDeChegada = horaDeChegada;
        this.capacidadeDePassageiros = capacidadeDePassageiros;
        this.assentosReservados = 0;
    }

    public void exibirInfo() {
        System.out.println("Voo Info");
        System.out.printf("Número: %d\n", this.numero);
        System.out.printf("Origem: %s\n", this.origem);
        System.out.printf("Destino: %s\n", this.destino);
        System.out.printf("Data de partida: %d/%d\n", this.dataDePartida.getMonthValue(), this.dataDePartida.getDayOfMonth());
        System.out.printf("Hora de partida: %d:%d\n", this.horaDePartida.getHour(), this.horaDePartida.getMinute());
        System.out.printf("Data de chegada: %d/%d\n", this.dataDeChegada.getMonthValue(), this.dataDeChegada.getDayOfMonth());
        System.out.printf("Hora de chegada: %d:%d\n\n", this.horaDeChegada.getHour(), this.horaDeChegada.getMinute());
    }

    /*
    Atributos:
        Número do Voo
        Origem
        Destino
        Data e Hora de Partida
        Data e Hora de Chegada
        Capacidade de Passageiros
        Assentos Reservados (indicando quantos assentos já foram reservados)
    Métodos:
        exibirInfo(): Exibe informações detalhadas sobre o Voo.
    */
}
