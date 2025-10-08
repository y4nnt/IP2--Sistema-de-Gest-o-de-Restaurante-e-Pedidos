package com.restaurante.classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private ClienteMesa clienteMesa;
    private List<ItemVenda> itensPedido;
    private Garcom garcomPedido;
    private String statusPedido;
    private LocalDate dataPedido;

        public Pedido(ClienteMesa clienteMesa, LocalDate data, Garcom garcom) {
        this.clienteMesa = clienteMesa;
        this.dataPedido = data;
        this.garcomPedido = garcom;
        this.itensPedido = new ArrayList<>();
        this.statusPedido = "ABERTO";
    }

    public void addItemPedido(Produto prato, int quantidade, String observacao) {
        if (prato == null || quantidade <= 0) {
            throw new IllegalArgumentException("Item ou quantidade inválida.");
        }

        ItemVenda novoItem = new ItemVenda(prato, quantidade, observacao);
        this.itensPedido.add(novoItem);
    }

        public double calcularValorTotal() {
        double total = 0;
        for (ItemVenda item : this.itensPedido) {
            total += item.calcularTotal();
        }
        return total;
    }

    public void atualizarStatusPedido(String status) {
        if (status != null && !status.trim().isEmpty()) {
            this.statusPedido = status;
        }
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public List<ItemVenda> getItensPedido() {
        return itensPedido;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- Detalhes do Pedido ---\n");
        sb.append("Data: ").append(dataPedido).append("\n");
        sb.append("Cliente/Mesa: ").append(clienteMesa).append("\n");
        sb.append("Garçom: ").append(garcomPedido).append("\n");
        sb.append("Status: ").append(statusPedido).append("\n");
        sb.append("Itens Pedidos:\n");

        for (ItemVenda item : itensPedido) {
            sb.append(item).append("\n");
        }

        sb.append("VALOR TOTAL: R$ ").append(String.format("%.2f", calcularValorTotal()));
        return sb.toString();
    }
}