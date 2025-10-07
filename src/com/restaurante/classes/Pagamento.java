package com.restaurante.classes;

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
            return pedido.getValorTotal() / quantidade;
        }
        return 0.0;
    }

    @Override
    public String toString() {
        return "Pagamento referente ao pedido: " + pedidoFinal;
    }
}

