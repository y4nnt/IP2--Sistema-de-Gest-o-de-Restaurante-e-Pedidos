package com.restaurante.classes;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
    private List<Pedido> pedidosPorCliente;
    private List<String> alergiasCliente;

    Cliente(String nomeUsuario, String cpf, String email, String telefone) {
        super(nomeUsuario, cpf, email, telefone);
        this.pedidosPorCliente = new ArrayList<>();
        this.alergiasCliente = new ArrayList<>();
    }

    public void addPedido(Pedido pedido) {
        this.pedidosPorCliente.add(pedido);
    }

    public void addAlergia (String alergia){
        this.alergiasCliente.add(alergia);
    }

    public void removerAlergia (String alergia){
        this.alergiasCliente.remove(alergia);
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(String.format("Tipo: %-20s \n",
                this.getClass()));
        sb.append("Alergias: ");
        for (String alergia : alergiasCliente) {
            sb.append(String.format("-%s; ", alergia));}
        return sb.toString();
    }

    public String relatorioCliente() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.toString());
        sb.append("\n");
        for (int i = 0; i < this.pedidosPorCliente.size(); i++) {
            sb.append(this.pedidosPorCliente.get(i).toString());
            sb.append("\n");
        }
    }
}
