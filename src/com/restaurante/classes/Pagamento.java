package com.restaurante.classes;

public class Pagamento {

    private Pedido pedidoFinal;

            public Pagamento(Pedido pedidoFinal) {
        if (pedidoFinal == null) {
            throw new IllegalArgumentException("O pagamento deve estar associado a um pedido válido.");
        }
        this.pedidoFinal = pedidoFinal;
    }

    public String pagarPedido(Pedido pedido) {
        if (pedido.calcularValorTotal() > 0) {
            pedido.atualizarStatusPedido("Entregue");
            return String.format("Pagamento de R$ %.2f realizado com sucesso. Pedido atualizado para PAGO.",
                    pedido.calcularValorTotal());
        }
        return "Nenhum valor a pagar.";
    }

    public double dividirPedido(Pedido pedido, int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade de pessoas para dividir deve ser maior que zero.");
        }
        return pedido.calcularValorTotal() / quantidade;
    }

    @Override
    public String toString() {
        return String.format("Pagamento pendente para Pedido do dia %s. Total: R$ %.2f",
                pedidoFinal.getDataPedido(), pedidoFinal.calcularValorTotal());

    }
}

