package avaliacao.model;

import java.util.UUID;

public class Organizador {
    public final UUID id;
    public final String nome;
    public final String email;
    public final Evento[] eventosOrganizados;

    public Organizador(String nome, String Email, int limite) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.email = Email;
        this.eventosOrganizados = new Evento[limite];
    }

    public boolean temEspacoParaEventos() {
        for (int i = 0; i < this.eventosOrganizados.length; i++) {
            if (this.eventosOrganizados[i] == null) {
                return true;
            }
        }
        return false;
    }

    public void adicionarEvento(Evento evento) {
        if (!this.temEspacoParaEventos()) {
            // Devido à forma como esse método é usado, esse bloco nunca é executado
            System.out.println("A lista de eventos deste organizador está cheia");
            return;
        }

        for (int i = 0; i < this.eventosOrganizados.length; i++) {
            if (this.eventosOrganizados[i] != null && this.eventosOrganizados[i] == evento) {
                // Devido à forma como esse método é usado, esse bloco nunca é executada
                System.out.printf("Evento \"%s\" já foi agendado por %s \n", evento.nome, this.nome);
                return;
            } else if (this.eventosOrganizados[i] == null) {
                this.eventosOrganizados[i] = evento;
                System.out.printf("Evento \"%s\" adicionado a %s \n", evento.nome, this.nome);
                return;
            }
        }
    }

    public void removerEvento(Evento evento) {
        for (int i = 0; i < this.eventosOrganizados.length; i++) {
            if (this.eventosOrganizados[i] == evento) {
                this.eventosOrganizados[i] = null;
                System.out.printf("Evento \"%s\" removido de %s \n", evento.nome, this.nome);
                return;
            }
        }
        // Devido à forma como esse método é usado, esse println nunca é executado
        System.out.println("Este evento não está na lista de eventos deste organizador");
    }

    public void exibirInfo() {
        System.out.println("|======= Organizador Info =======|");
        System.out.println("Nome: " + this.nome);
        System.out.println("Email: " + this.email);
        System.out.println("|== Eventos Organizados Inicio ==|");
        for (int i = 0; i < this.eventosOrganizados.length; i++) {
            if (this.eventosOrganizados[i] != null) {
                this.eventosOrganizados[i].exibirInfo();
            }
        }
        System.out.println("|== Eventos Organizados Fim =====|\n");
    }

    /*
    Atributos:
        Nome
        ID
        E-mail
        Eventos Organizados (uma lista de objetos de evento, com limite de eventos por organizador)
    Métodos:
        exibirInfo(): Exibe informações detalhadas sobre o organizador
    */

}