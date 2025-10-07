package com.restaurante.classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private ClienteMesa clienteMesa;
    private List<ItemVenda> pedidoMesa;
    private int statusPedido;
    private LocalDate dataPedido;

    public Pedido(ClienteMesa clienteMesa, LocalDate data) {
        this.clienteMesa = clienteMesa;
        this.dataPedido = data;
        this.pedidoMesa = new ArrayList<>();
        this.statusPedido = 0;
    }
    public ClienteMesa getClienteMesa() {
        return clienteMesa;
    }

    public List<ItemVenda> getPedidoMesa() {
        return pedidoMesa;
    }

    public int getStatusPedido() {
        return statusPedido;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }
    public void addItemPedido(ItemVenda prato, int quantidade, String observacao) {
        prato.setQuantidade(quantidade);
        prato.setObservacao(observacao);
        pedidoMesa.add(prato);
    }

    public double calcularValorTotal() {
        double total = 0;
        for (ItemVenda item : pedidoMesa) {
            total += item.getProdutoVendido().getPrecoProduto() * item.getQuantidade();
        }
        return total;
    }

    public void atualizarStatusPedido(String status) {
        switch (status.toLowerCase()) {
            case "em andamento":
                this.statusPedido = 0;
                break;
            case "pronto":
                this.statusPedido = 1;
                break;
            case "entregue":
                this.statusPedido = 2;
                break;
            default:
                throw new IllegalArgumentException("Status inválido: " + status);
        }
    }
    @Override
    public String toString() {
        return "Pedido {" +
                "clienteMesa=" + clienteMesa +
                ", itens=" + pedidoMesa +
                ", statusPedido=" + statusPedido +
                ", dataPedido=" + dataPedido +
                ", valorTotal=" + calcularValorTotal() +
                '}';
    }

}
