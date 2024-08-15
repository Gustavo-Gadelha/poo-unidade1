package escopo5.model;

public class RedeSocial {
    public final Usuario[] usuarios = new Usuario[20];

    public void inserirUsuario(Usuario usuario) {
        if (buscarUsuarioPorNome(usuario.username)) {
            System.out.println("Nome de usuário já está cadastrado!");
            return;
        }

        for (int i = 0; i < this.usuarios.length; i++) {
            if (this.usuarios[i] == null) {
                this.usuarios[i] = usuario;
                return;
            }
        }
        System.out.println("Espaço insuficiente para mais Usuários");
    }

    public boolean buscarUsuarioPorNome(String nome) {
        for (int i = 0; i < this.usuarios.length; i++) {
            if (this.usuarios[i] != null && this.usuarios[i].username.equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }

    /*
    Atributos:
        Lista de Usuários (limite de usuários)
    Métodos:
        inserirUsuario(): Permite inserir um usuário na Rede social.
        buscarUsuarioPorNome(): Permite a busca de usuários por nome (username).
        visualizarFeedNoticias(): Exibe o feed de notícias dos usuários.
    */
}
