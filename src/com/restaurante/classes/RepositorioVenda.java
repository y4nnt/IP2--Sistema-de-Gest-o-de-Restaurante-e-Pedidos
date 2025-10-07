package com.restaurante.classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RepositorioVenda {
    private List<Pedido> repositorioVenda;

    public RepositorioVenda() {
        this.repositorioVenda = new ArrayList<>();
    }
    public List<Pedido> getRepositorioVenda() {
        return repositorioVenda;
    }
    public void addVenda(Pedido venda) {
        if (venda != null) {
            repositorioVenda.add(venda);
        } else {
            throw new IllegalArgumentException("A venda não pode ser nula.");
        }
    }
    public void removerVenda(Pedido venda) {
        if (!repositorioVenda.remove(venda)) {
            System.out.println("Venda não encontrada no repositório.");
        }
    }
    public String relatorioVenda(LocalDate inicio, LocalDate fim) {
        StringBuilder relatorio = new StringBuilder();
        double totalPeriodo = 0;

        relatorio.append("📅 Relatório de Vendas de ")
                .append(inicio).append(" até ").append(fim).append("\n")
                .append("--------------------------------------------------\n");

        for (Pedido p : repositorioVenda) {
            LocalDate dataPedido = p.getDataPedido();

            if ((dataPedido.isAfter(inicio) || dataPedido.isEqual(inicio)) &&
                    (dataPedido.isBefore(fim) || dataPedido.isEqual(fim))) {

                relatorio.append(p.toString()).append("\n\n");
                totalPeriodo += p.calcularValorTotal();
            }
        }

        relatorio.append("--------------------------------------------------\n")
                .append("💰 Total de vendas no período: R$ ")
                .append(String.format("%.2f", totalPeriodo));

        return relatorio.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("📦 Repositório de Vendas:\n");
        for (Pedido p : repositorioVenda) {
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }


}
