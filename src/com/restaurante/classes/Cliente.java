package com.restaurante.classes;

import java.util.List;

public class Cliente extends Usuario {
    private List<Pedido> pedidosPorCliente;

    Cliente(String nomeUsuario, String cpf, String email, String telefone) {
        super(nomeUsuario, cpf, email, telefone);
    }

    public void addPedido(Pedido pedido) {
        this.pedidosPorCliente.add(pedido);
    }

    @Override
    public String toString() {
        return super.toString() + "Tipo: " + this.getClass();
    }

    public String relatorioCliente() {
        return "a";
    }
}
