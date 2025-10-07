package com.restaurante.classes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Reserva {
    private ClienteMesa clienteMesa;
    private LocalDateTime dataReserva;
    private int numeroPessoas;

    Reserva (ClienteMesa clienteMesa, LocalDateTime dataReserva, int numeroPessoas){
        this.clienteMesa = clienteMesa;
        this.dataReserva = dataReserva;
        this.numeroPessoas = numeroPessoas;
    }

    public String reservarMesa (Reserva reserva){
        String resultado = "Mesa reservada.";
        if (this.clienteMesa.getMesaPedido().getCapacidadeMesa() < reserva.getNumeroPessoas()){
            resultado = "A mesa não possui capacidade para todos.";
        }
        return resultado;
    }

    public String cancelarReservaMesa (){
        String resultado = "O cancelamento não pôde ser efetuado.";
        if (getDataReserva().isAfter(LocalDateTime.now().plusHours(1))){
            resultado = "Cancelamento efetuado com sucesso.";
        }
        return resultado;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHoraFormatada = dataReserva.format(formatador);

        sb.append(String.format("Data da reserva: %s\n", dataHoraFormatada));
        sb.append(String.format("Cliente: %-15s | CPF: %-15s | Telefone: %-15s\n",
                this.clienteMesa.getClientePedido().getNomeUsuario(),
                this.clienteMesa.getClientePedido().getCpf(),
                this.clienteMesa.getClientePedido().formatarTelefone()));
        sb.append(String.format("Mesa: %-15s | Capacidade: %-15s\n"),
                this.clienteMesa.getMesaPedido().getNumeroMesa(),
                this.clienteMesa.getMesaPedido().getCapacidadeMesa());

        return sb.toString();
    }

    public ClienteMesa getClienteMesa() {
        return clienteMesa;
    }

    public void setClienteMesa(ClienteMesa clienteMesa) {
        this.clienteMesa = clienteMesa;
    }

    public LocalDateTime getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDateTime dataReserva) {
        this.dataReserva = dataReserva;
    }

    public int getNumeroPessoas() {
        return numeroPessoas;
    }

    public void setNumeroPessoas(int numeroPessoas) {
        this.numeroPessoas = numeroPessoas;
    }
}
