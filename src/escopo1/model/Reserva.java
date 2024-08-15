package escopo1.model;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

public class Reserva {
    public final Cliente cliente;
    public final Quarto quarto;
    public final LocalDate dataCheckIn;
    public final LocalDate dataCheckOut;
    public final double total;

    public Reserva(Cliente cliente, Quarto quarto, LocalDate dataCheckIn, LocalDate dataCheckOut) {
        this.cliente = cliente;
        this.quarto = quarto;
        this.quarto.disponivel = false;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.total = calcularTotal();
    }

    public double calcularTotal() {
        return DAYS.between(this.dataCheckIn, this.dataCheckOut) * this.quarto.precoPorNoite;
    }

    public void exibirInfo() {
        System.out.println("Reserva Info");
        System.out.printf("Nome do cliente: %s\n", this.cliente.nome);
        System.out.printf("numero do quarto: %d\n", this.quarto.numero);
        System.out.printf("Data de Check-in: %s/%s\n", this.dataCheckIn.getDayOfMonth(), this.dataCheckIn.getMonthValue());
        System.out.printf("Data de Check-out: %s/%s\n", this.dataCheckIn.getDayOfMonth(), this.dataCheckIn.getMonthValue());
    }


    /*
    Atributos:
        Cliente (referência ao cliente que fez a reserva)
        Quarto (referência ao quarto reservado)
        Data de Check-In
        Data de Check-Out
    Métodos:
        calcularTotal(): Calcula o valor total da reserva com base nas datas de check-in e check-out e no preço do quarto.
        exibirInfo(): Exibe informações detalhadas sobre o livro.
    */

}
