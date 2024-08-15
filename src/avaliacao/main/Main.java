package avaliacao.main;


import avaliacao.model.Calendario;
import avaliacao.model.Evento;
import avaliacao.model.Organizador;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Evento evento1 = new Evento(
                "Carnaval",
                LocalDate.of(2023, 2, 8),
                LocalTime.of(22, 13),
                "Rua dos Bobos",
                120
        );

        Evento evento2 = new Evento(
                "São joão",
                LocalDate.of(2023, 6, 15),
                LocalTime.of(17, 15),
                "Rua dos Santos",
                213
        );

        Evento evento3 = new Evento(
                "Ano novo",
                LocalDate.of(2023, 12, 30),
                LocalTime.of(23, 59),
                "Rua dos Malês",
                2516
        );

        Evento evento3data = new Evento(
                "Natal",
                LocalDate.of(2023, 12, 30),
                LocalTime.of(19, 0),
                "Rua dos Helvéticos",
                156
        );

        Evento evento3local = new Evento(
                "Dia de São Miguel",
                LocalDate.of(2023, 9, 29),
                LocalTime.of(17, 50),
                "Rua dos Malês",
                289
        );

        Organizador organizador1 = new Organizador(
                "Organizador1",
                "Organizador1@email.com",
                11
        );

        Organizador organizador2 = new Organizador(
                "Organizador2",
                "Organizador2@email.com",
                3
        );

        Organizador organizador3 = new Organizador(
                "Organizador3",
                "Organizador3@email.com",
                7
        );

        Calendario calendario = new Calendario(
                10
        );

        System.out.println("Calendario - Metodos teste:\n");
        // Organizador 1; inserir eventos 1 (Carnaval) e 2 (São João)
        calendario.inserirEvento(organizador1, evento1);
        calendario.inserirEvento(organizador1, evento2);

        // Organizador 1; inserir evento 3 (Ano novo); lista de eventos do organizador1 cheia
        calendario.inserirEvento(organizador1, evento3);

        // Organizador 1; cancelar evento 2 (São João); inserir evento 3 (Ano novo)
        calendario.cancelarEvento(organizador1, evento2);
        calendario.inserirEvento(organizador1, evento3);

        // Organizador 2; inserir evento 2 (São João)
        calendario.inserirEvento(organizador2, evento2);

        // Organizador 1; cancelar evento 2 (São João) do Organizador 2
        calendario.cancelarEvento(organizador1, evento2);

        // Organizador 3; inserir evento 3data (Natal) e 3local (Dia de São Miguel)
        calendario.inserirEvento(organizador3, evento3data);
        calendario.inserirEvento(organizador3, evento3local);

        // exibir informações dos eventos 1 (Carnaval), 2 (São João) e 3 (Ano novo)
        System.out.println("\nEventos - exibirInfo teste:\n");
        evento1.exibirInfo();
        evento2.exibirInfo();
        evento3.exibirInfo();

        // exibir informações do organizador 1 e 2
        System.out.println("Organizador - exibirInfo teste:\n");
        organizador1.exibirInfo();
        organizador2.exibirInfo();

        // exibir informações do calendário
        System.out.println("Calendario - exibirInfo teste:\n");
        calendario.exibirInfo();
    }
}