package com.restaurante.classes;

public class ClienteMesa {
    private Cliente clientePedido;
    private Mesa mesaPedido;

    ClienteMesa(Cliente clientePedido, Mesa mesaPedido) {
        this.clientePedido = clientePedido;
        this.mesaPedido = mesaPedido;
    }
}
