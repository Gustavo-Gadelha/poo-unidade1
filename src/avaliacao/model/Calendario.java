package avaliacao.model;

import java.time.LocalDate;

public class Calendario {
    public final ReservaEspaco[] eventosReservados;

    public Calendario(int numeroDeEventos) {
        this.eventosReservados = new ReservaEspaco[numeroDeEventos];
    }

    // Método sobrecarregado; Verificar disponibilidade por data, se disponível, return true
    public boolean verificarDisponibilidade(LocalDate data) {
        for (int i = 0; i < this.eventosReservados.length; i++) {
            if (this.eventosReservados[i] != null && this.eventosReservados[i].evento.data.equals(data)) {
                return false;
            }
        }
        return true;
    }

    // Método sobrecarregado; Verificar disponibilidade por local, se disponível, return true
    public boolean verificarDisponibilidade(String local) {
        for (int i = 0; i < this.eventosReservados.length; i++) {
            if (this.eventosReservados[i] != null && this.eventosReservados[i].evento.local.equals(local)) {
                return false;
            }
        }
        return true;
    }

    public void inserirEvento(Organizador organizador, Evento evento) {
        if (!organizador.temEspacoParaEventos()) {
            System.out.println("A lista de eventos organizados deste organizador está cheia");
            return;
        }

        if (!this.verificarDisponibilidade(evento.data) && !this.verificarDisponibilidade(evento.local)) {
            System.out.printf("Data e Local indisponíveis para \"%s\"\n", evento.nome);
            return;
        }

        for (int i = 0; i < this.eventosReservados.length; i++) {
            if (this.eventosReservados[i] == null) {
                this.eventosReservados[i] = new ReservaEspaco(organizador, evento);
                organizador.adicionarEvento(evento);
                return;
            }
        }

        System.out.println("A lista de eventos reservados deste calendário está cheia");
    }

    public void cancelarEvento(Organizador organizador, Evento evento) {
        for (int i = 0; i < this.eventosReservados.length; i++) {
            if (this.eventosReservados[i] != null && this.eventosReservados[i].evento == evento) {
                if (this.eventosReservados[i].organizador != organizador) {
                    System.out.println("Este organizador não pode cancelar um evento de outro organizador");
                } else {
                    organizador.removerEvento(evento);
                    this.eventosReservados[i] = null;
                }
                return;
            }
        }
        System.out.println("Evento não encontrado");
    }

    public void exibirInfo() {
        System.out.println("|====== Calendário inicio =======|");
        for (int i = 0; i < this.eventosReservados.length; i++) {
            if (this.eventosReservados[i] != null) {
                this.eventosReservados[i].exibirInfo();
            }
        }
        System.out.println("|====== Calendário fim ==========|\n");
    }

    /*
    Atributos:
        Lista de Eventos Agendados (limite de eventos agendados)
    Métodos:
        verificarDisponibilidade(): Verifica a disponibilidade de datas para agendar eventos.
        inserirEvento(): Permite aos organizadores inserirem os eventos.
        cancelarEvento(): Permite aos organizadores cancelarem um evento.
        exibirInfo(): Exibe informações detalhadas sobre o calendário, incluindo a lista de eventos agendados.
    */

}
