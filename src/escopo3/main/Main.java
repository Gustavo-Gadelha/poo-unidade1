package escopo3.main;


import escopo3.model.Aeroporto;
import escopo3.model.Passageiro;
import escopo3.model.Voo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Passageiro passageiro = new Passageiro(
                "Carlos",
                "Carlos@email.com"
        );

        Voo voo = new Voo(
                1,
                "Brasil",
                "Polônia",
                LocalDate.of(2023, 9, 10),
                LocalTime.of(12, 0),
                LocalDate.of(2023, 9, 10),
                LocalTime.of(12, 0),
                200
        );

        Aeroporto aeroporto = new Aeroporto(
                "Castelo Branco",
                "Rua dos tolos"
        );

        aeroporto.fazerReserva(passageiro, voo, 10);

        passageiro.exibirInfo();
        voo.exibirInfo();
        aeroporto.exibirInfo();
    }
}