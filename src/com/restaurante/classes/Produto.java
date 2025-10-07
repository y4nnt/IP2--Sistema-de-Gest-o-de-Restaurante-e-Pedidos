package com.restaurante.classes;

import java.time.format.DateTimeFormatter;

public class Produto {
    private String nomeProduto;
    private String descricaoProduto;
    private double precoProduto;
    private String categoriaProduto;
    private boolean statusItem;
    private int numeroVendas;
    private String codigoItem;

    // Depois, incluir try-catch em todos, evitando problemas futuros.
    public Produto(String nomeProduto, String descricaoProduto, double precoProduto, String categoriaProduto, boolean statusItem, String codigoItem) {
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;

        this.categoriaProduto = categoriaProduto;
        this.statusItem = statusItem;
        this.codigoItem = codigoItem;

        // Primeiro verifica se o preço inicializado é negativo, se for, retorna 0,
        // sendo um produto "sem preço".
        if(precoProduto < 0){
            this.precoProduto = 0;
        }
        else {
            this.precoProduto = precoProduto;
        }

        // Inicializa em 0, pois vai ser aumentado com o metodo addNumeroVendas
        this.numeroVendas = 0;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public String getCategoriaProduto() {
        return categoriaProduto;
    }

    public void setCategoriaProduto(String categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }

    public boolean getStatusItem() {
        return statusItem;
    }

    public void setStatusItem(boolean statusItem) {
        this.statusItem = statusItem;
    }

    public int getNumeroVendas() {
        return numeroVendas;
    }

    public String getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(String codigoItem) {
        this.codigoItem = codigoItem;
    }

    // Quando um produto for vendido, esse metodo será usado para indicar o numero de vendas
    public void addNumeroVendas(){
        this.numeroVendas++;
    }

    // Retorna uma String no formato de linha à linha, necessitando de um sout para mostrar
    public String toString(){
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Nome: %-15s | Código: %-15s | Preço: %-15s\n",
                this.nomeProduto,
                this.codigoItem,
                this.precoProduto));
        sb.append(String.format("Descrição: %s",
                this.descricaoProduto));
        sb.append(String.format("Categoria: %-15s | Número de vendas: %-15s | Status: ",
                this.categoriaProduto,
                this.numeroVendas));
        if (this.statusItem) {
            sb.append(String.format("Disponível\n"));
        } else {
            sb.append(String.format("Indisponível\n"));
        }

        return sb.toString();
    }

    @Override
    public int hashCode(){
        return Integer.parseInt(this.getCodigoItem());
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null || this.getClass() != o.getClass()){
            return false;
        }

        Produto produto = (Produto) o;

        return this.getCodigoItem().equals(produto.getCodigoItem());

    }

}
