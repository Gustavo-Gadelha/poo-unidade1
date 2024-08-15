package escopo4.model;

import java.util.UUID;

public class Organizador {
    public final UUID id;
    public final String nome;
    public final String email;
    public final Evento[] eventosOrganizados = new Evento[2];

    public Organizador(String nome, String email) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.email = email;
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
        System.out.printf("Nome do Organizador: %s\n", this.nome);
        System.out.printf("E-mail do Organizador: %s\n", this.email);
        System.out.print("Eventos organizados: ");
        for (int i = 0; i < this.eventosOrganizados.length; i++) {
            if (this.eventosOrganizados[i] != null) {
                System.out.print(this.eventosOrganizados[i].nome + "; ");
            }
        }
        System.out.println("\n");
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
