package com.restaurante.classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private ClienteMesa clienteMesa;
    private Garcom garcomPedido;
    private Chef chefPedido;
    private List<ItemVenda> pedidoMesa;
    private StatusPedido statusPedido;
    private LocalDate dataPedido;

    public Pedido(ClienteMesa clienteMesa, Garcom garcom, Chef chef, LocalDate data) {
        if (clienteMesa != null) {
            this.clienteMesa = clienteMesa;
            this.garcomPedido = garcom;
            this.chefPedido = chef;
            this.dataPedido = data;
            this.pedidoMesa = new ArrayList<>();
            this.statusPedido = StatusPedido.EM_ANDAMENTO;
        } else {
            throw new IllegalArgumentException("O cliente da mesa não pode ser nulo para criar um pedido.");
        }
    }

    public void addItemPedido(ItemVenda prato, int quantidade, String observacao) {
        prato.setQuantidade(quantidade);
        prato.setObservacaoPedido(observacao);
        pedidoMesa.add(prato);
    }

    public double calcularValorTotal() {
        double total = 0;
        for (ItemVenda item : pedidoMesa) {
            total += item.getProdutoVendido().getPrecoProduto() * item.getQuantidade();
        }
        return total;
    }

    public void atualizarStatusPedido(StatusPedido status) {
        this.statusPedido  = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHoraFormatada = this.dataPedido.format(formatador);

        sb.append(String.format("Data: %s\n", dataHoraFormatada));
        sb.append(String.format("Cliente: %-15s | CPF: %-15s | Telefone: %-15s\n",
                this.clienteMesa.getClientePedido().getNomeUsuario(),
                this.clienteMesa.getClientePedido().getCpf(),
                this.clienteMesa.getClientePedido().formatarTelefone()));
        sb.append("Mesa: %-15s | Capacidade: %-15s\n",
                this.clienteMesa.getMesaPedido().getNumeroMesa(),
                this.clienteMesa.getMesaPedido().getCapacidadeMesa());
        sb.append(String.format("Total: R$ " + this.calcularValorTotal()));

        return sb.toString();
    }

    public ClienteMesa getClienteMesa() {
        return clienteMesa;
    }

    public void setClienteMesa(ClienteMesa clienteMesa) {
        this.clienteMesa = clienteMesa;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }
    //set via codigo
    public void setStatusPedidoCodigo(int codigoStatusPedido) {
        this.statusPedido = StatusPedido.fromCodigo(codigoStatusPedido);
    }

    public Garcom getGarcomPedido() {
        return garcomPedido;
    }

    public void setGarcomPedido(Garcom garcomPedido) {
        this.garcomPedido = garcomPedido;
    }

    public Chef getChefPedido() {
        return chefPedido;
    }

    public void setChefPedido(Chef chefPedido) {
        this.chefPedido = chefPedido;
    }

    public List<ItemVenda> getPedidoMesa() {
        return pedidoMesa;
    }

    public void setPedidoMesa(List<ItemVenda> pedidoMesa) {
        this.pedidoMesa = pedidoMesa;
    }


}
