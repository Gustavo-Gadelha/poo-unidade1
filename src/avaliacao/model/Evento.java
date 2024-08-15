package avaliacao.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class Evento {
    public final UUID id;
    public final String nome;
    public final LocalDate data;
    public final LocalTime hora;
    public final String local;
    public final int capacidadeDeParticipantes;
    public final int participantesRegistrados;

    public Evento(String nome, LocalDate data, LocalTime hora, String local, int capacidadeDeParticipantes) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.local = local;
        this.capacidadeDeParticipantes = capacidadeDeParticipantes;
        this.participantesRegistrados = 0;
    }

    public void exibirInfo() {
        System.out.println("|========== Evento Info =========|");
        System.out.println("Nome: " + this.nome);
        System.out.println("Data: " + this.data);
        System.out.printf("Hora: %02d:%02d\n", this.hora.getHour(), this.hora.getMinute());
        System.out.println("Local: " + this.local);
        System.out.println("Capacidade de Participantes: " + this.capacidadeDeParticipantes);
        System.out.println("Quantidade de Participantes Registrados: " + this.participantesRegistrados + "\n");
    }

    /*
    Atributos:
        ID
        Nome
        Data
        Hora
        Local
        Capacidade de Participantes
        Participantes Registrados (indicando quantos participantes já estão registrados para o evento)
    Métodos:
        exibirInfo(): Exibe informações detalhadas sobre o evento.
    */

}
