package escopo3.model;

public class Aeroporto {
    public final String nome;
    public final String localizacao;
    public final Reserva[] listaDeReservas;

    public Aeroporto(String nome, String localizacao) {
        this.nome = nome;
        this.localizacao = localizacao;
        this.listaDeReservas = new Reserva[10];
    }

    public boolean buscarVooPorNumero(int numero) {
        for (int i = 0; i < this.listaDeReservas.length; i++) {
            if (this.listaDeReservas[i] != null && this.listaDeReservas[i].voo.numero == numero) {
                return true;
            }
        }
        return false;
    }

    public void fazerReserva(Passageiro passageiro, Voo voo, int numeroDeAssentos) {
        if (this.buscarVooPorNumero(voo.numero)) {
            System.out.println("Este voo já foi cadastrado");
            return;
        }

        for (int i = 0; i < this.listaDeReservas.length; i++) {
            if (this.listaDeReservas[i] == null) {
                this.listaDeReservas[i] = new Reserva(passageiro, voo, numeroDeAssentos);
                return;
            }
        }
        System.out.println("Não é possível fazer mais reservas!");
    }

    public void cancelarReserva(Passageiro passageiro, Voo voo) {
        if (!this.buscarVooPorNumero(voo.numero)) {
            System.out.println("Este voo não foi reservado");
            return;
        }

        for (int i = 0; i < this.listaDeReservas.length; i++) {
            if (this.listaDeReservas[i] != null && this.listaDeReservas[i].voo == voo) {
                if (this.listaDeReservas[i].passageiro != passageiro) {
                    System.out.println("Este organizador não pode cancelar está reserva");
                } else {
                    this.listaDeReservas[i] = null;
                }
                return;
            }
        }
        System.out.println("Não é possível fazer mais reservas!");
    }

    public void exibirInfo() {
        System.out.println("Aeroporto Info");
        System.out.printf("Nome: %s\n", this.nome);
        System.out.printf("Localização: %s\n", this.localizacao);
        System.out.println("Lista de reservas: ");
        for (int i = 0; i < this.listaDeReservas.length; i++) {
            if (this.listaDeReservas[i] != null) {
                this.listaDeReservas[i].exibirInfo();
            }
        }
        System.out.println();
    }
    /*
    Atributos:
        Nome
        Localização
        Lista de Reservas (Com limite)
    Métodos:
        buscarVoos(): Permite aos usuários pesquisar voos disponíveis com base no número
        fazerReserva(): Permite aos passageiros fazerem uma reserva de voo.
        cancelarReserva(): Permite aos passageiros cancelarem uma reserva.
        exibirInfo(): Exibe informações detalhadas sobre o aeroporto, incluindo a lista de voos disponíveis.
    */
}
