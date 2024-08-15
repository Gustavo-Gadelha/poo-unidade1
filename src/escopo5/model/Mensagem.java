package escopo5.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Mensagem {
    public final Usuario autor;
    public final String conteudo;
    public final LocalDate data;
    public final LocalTime hora;

    public Mensagem(Usuario autor, String conteudo) {
        this.autor = autor;
        this.conteudo = conteudo;
        this.data = LocalDate.now();
        this.hora = LocalTime.now();
    }

    public void exibirInfo() {
        System.out.printf("Autor da mensagem: %s\n", this.autor.username);
        System.out.printf("Conteúdo da mensagem: \n - %s\n", this.conteudo);
        System.out.println("Data da mensagem: " + this.data);
        System.out.println("Hora da mensagem: " + this.hora);
        System.out.println();
    }

    /*
    Atributos:
        Autor (referência ao usuário que escreveu a mensagem)
        Conteúdo da Mensagem
        Data e Hora de Publicação
    Métodos:
        exibirInfo(): Exibe informações detalhadas sobre a mensagem.
    */
}
