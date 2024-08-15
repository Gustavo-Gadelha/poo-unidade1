package escopo1.main;


import escopo1.model.Cliente;
import escopo1.model.Hotel;
import escopo1.model.Quarto;
import escopo1.model.Reserva;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Reserva reserva = new Reserva(
                new Cliente("Carlos", "Carlos@email.com"),
                new Quarto(1, "Simples"),
                LocalDate.of(2023, 9, 18),
                LocalDate.of(2023, 10, 18)
        );

        System.out.println(reserva.total);

        Hotel hotel = new Hotel("O Cesariano", "Avenida Juliana", 30);
        for (int i = 0; i < hotel.quartos.length; i++) {
            System.out.println(hotel.quartos[i].numero);
        }

    }
}