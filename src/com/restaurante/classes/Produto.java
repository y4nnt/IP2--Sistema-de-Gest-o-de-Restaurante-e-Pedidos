package com.restaurante.classes;

public class Produto {
    private String nomeProduto;
    private String descricaoProduto;
    private double precoProduto;
    private String categoriaProduto;
    private boolean statusItem;
    private int numeroVendas;
    private String codigoItem;

    public Produto(String nomeProduto, String descricaoProduto, double precoProduto, String categoriaProduto, boolean statusItem, String codigoItem) {
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.precoProduto = precoProduto;
        this.categoriaProduto = categoriaProduto;
        this.statusItem = statusItem;
        this.codigoItem = codigoItem;

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

    public boolean isStatusItem() {
        return statusItem;
    }

    public void setStatusItem(boolean statusItem) {
        this.statusItem = statusItem;
    }

    public int getNumeroVendas() {
        return numeroVendas;
    }

    public void setNumeroVendas(int numeroVendas) {
        this.numeroVendas = numeroVendas;
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
        return String.format(
                "Produto {\n" +
                        "Codigo: %s\n" +
                        "Nome: %s\n" +
                        "Descrição: %s\n" +
                        "Preço: R$%.2f\n" +
                        "Categoria: %s\n" +
                        "Status: %b\n" +
                        "Numero de vendas: %d\n" +
                "}\n",
                this.codigoItem,
                this.nomeProduto,
                this.descricaoProduto,
                this.precoProduto,
                this.categoriaProduto,
                this.statusItem,
                this.numeroVendas
        );
    }

}
