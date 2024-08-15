package escopo5.model;

import java.time.LocalDate;
import java.util.UUID;

public class Usuario {
    public final UUID id;
    public final String username;
    public final String nomeReal;
    public final LocalDate dataDeNascimento;
    public final Usuario[] amigos = new Usuario[10];
    public final Mensagem[] mensagens = new Mensagem[20];
    public final Foto[] fotos = new Foto[10];

    public Usuario(String nomeUsuario, String nomeReal, LocalDate dataDeNascimento) {
        this.id = UUID.randomUUID();
        this.username = nomeUsuario;
        this.nomeReal = nomeReal;
        this.dataDeNascimento = dataDeNascimento;
    }

    public void adicionarAmigo(Usuario usuario) {
        for (int i = 0; i < this.amigos.length; i++) {
            if (this.amigos[i] == null) {
                this.amigos[i] = usuario;
                return;
            }
        }
        System.out.println("Espaço insuficiente para mais Amigos");
    }

    private void adicionarMensagem(Mensagem mensagem) {
        for (int i = 0; i < this.mensagens.length; i++) {
            if (this.mensagens[i] == null) {
                this.mensagens[i] = mensagem;
                return;
            }
        }
        System.out.println("Espaço insuficiente para mais Mensagens");
    }

    private void adicionarFoto(Foto foto) {
        for (int i = 0; i < this.fotos.length; i++) {
            if (this.fotos[i] == null) {
                this.fotos[i] = foto;
                return;
            }
        }
        System.out.println("Espaço insuficiente para mais Fotos");
    }

    public void compartilharMensagem(String conteudo) {
        Mensagem mensagem = new Mensagem(this, conteudo);
        for (int i = 0; i < this.amigos.length; i++) {
            if (this.amigos[i] != null) {
                this.amigos[i].adicionarMensagem(mensagem);
            }
        }
    }

    public void compartilharFoto(String descricao, String url) {
        Foto foto = new Foto(this, descricao, url);
        for (int i = 0; i < this.amigos.length; i++) {
            if (this.amigos[i] != null) {
                this.amigos[i].adicionarFoto(foto);
            }
        }
    }

    public void verFeedNoticias() {
        System.out.printf("Mensagens compartilhadas com \"%s\": \n", this.username);
        for (int i = 0; i < this.mensagens.length; i++) {
            if (this.mensagens[i] != null) {
                this.mensagens[i].exibirInfo();
            }
        }

        System.out.printf("Fotos compartilhadas com \"%s\": \n", this.username);
        for (int i = 0; i < this.fotos.length; i++) {
            if (this.fotos[i] != null) {
                this.fotos[i].exibirInfo();
            }
        }
    }

    public void exibirInfo() {
        System.out.printf("Nome de Usuario: %s\n", this.username);
        System.out.printf("Nome Real: %s\n", this.nomeReal);
        System.out.println("Data de nascimento: " + this.dataDeNascimento);
        System.out.println("Amigos: ");
        for (int i = 0; i < this.amigos.length; i++) {
            if (this.amigos[i] != null) {
                System.out.println(" - " + this.amigos[i].username);
            }
        }
    }

    /*
    Atributos:
        ID do Usuário
        Nome de Usuário
        Nome Real
        Data de Nascimento
        Lista de Amigos (limite de amigos)
        Lista de Mensagens (limite de mensagens)
        Lista de Fotos (limite de fotos)
    Métodos:
        exibirInfo(): Exibe informações detalhadas sobre o usuário.
        adicionarAmigo(): Permite aos usuários adicionar outros usuários como amigos.
        compartilharMensagem(): Permite aos usuários compartilharem mensagens com seus amigos.
        compartilharFoto(): Permite aos usuários compartilharem fotos com seus amigos.
        verFeedNoticias(): Exibe o feed de notícias do usuário, mostrando mensagens e fotos compartilhadas por amigos.
    */
}
