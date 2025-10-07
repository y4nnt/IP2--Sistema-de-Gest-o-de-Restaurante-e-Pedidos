package com.restaurante.classes;

import java.time.format.DateTimeFormatter;

public class Pagamento {
    private Pedido pedidoFinal;

    public Pagamento(Pedido pedidoFinal) {
        this.pedidoFinal = pedidoFinal;
    }

    public String pagarPedido(Pedido pedido) {
        if (pedido != null) {
            return "Pagamento do pedido " + pedido + " realizado com sucesso!";
        }
        return "Pedido inválido. Pagamento não realizado.";
    }

    // Divide o valor do pedido entre as pessoas
    public double dividirPedido(Pedido pedido, int quantidade) {
        if (pedido != null && quantidade > 0) {
            return pedido.calcularValorTotal() / quantidade;
        }
        return 0.0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHoraFormatada = pedidoFinal.getDataPedido().format(formatador);

        sb.append(String.format("Data do pagamento: %-15s\n", dataHoraFormatada));
        sb.append(String.format("Cliente: %-15s | CPF: %-15s | Telefone: %-15s\n",
                this.pedidoFinal.getClienteMesa().getClientePedido().getNomeUsuario(),
                this.pedidoFinal.getClienteMesa().getClientePedido().getCpf(),
                this.pedidoFinal.getClienteMesa().getClientePedido().formatarTelefone()));
        sb.append(String.format("Valor: %-15s\n",
                this.pedidoFinal.calcularValorTotal()));

        return sb.toString();
    }
}

