package escopo5.main;


import escopo5.model.RedeSocial;
import escopo5.model.Usuario;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Usuario user1 = new Usuario(
                "ohmagah",
                "Carlos",
                LocalDate.of(2000, 12, 30)
        );

        Usuario user2 = new Usuario(
                "goodame",
                "Carlos",
                LocalDate.of(2000, 12, 30)
        );

        RedeSocial mynetwork = new RedeSocial();

        mynetwork.inserirUsuario(user1);
        mynetwork.inserirUsuario(user2);

        user1.adicionarAmigo(user2);
        user1.compartilharMensagem("Repudio o curso de Letras!");
        user1.compartilharFoto("Me at home", "www.imgur.com");

        user2.verFeedNoticias();
        user1.exibirInfo();
    }
}