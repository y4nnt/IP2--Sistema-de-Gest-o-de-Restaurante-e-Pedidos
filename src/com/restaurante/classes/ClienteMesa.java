package com.restaurante.classes;

public class ClienteMesa {
    private Cliente clientePedido;
    private Mesa mesaPedido;

    public ClienteMesa(Cliente clientePedido, Mesa mesaPedido) {
        this.clientePedido = clientePedido;
        this.mesaPedido = mesaPedido;
    }

    public Cliente getClientePedido() {
        return clientePedido;
    }

    public void setClientePedido(Cliente clientePedido) {
        this.clientePedido = clientePedido;
    }

    public Mesa getMesaPedido() {
        return mesaPedido;
    }

    public void setMesaPedido(Mesa mesaPedido) {
        this.mesaPedido = mesaPedido;
    }
}
