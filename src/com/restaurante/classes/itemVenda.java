package com.restaurante.classes;

public class itemVenda {
    private Produto produtoVendido;
    private int quantidade;

    public itemVenda(Produto produtoVendido, int quantidade) {
        this.produtoVendido = produtoVendido;
        this.quantidade = quantidade;
    }

    public Produto getProdutoVendido() {
        return produtoVendido;
    }

    public void setProdutoVendido(Produto produtoVendido) {
        this.produtoVendido = produtoVendido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double calcularTotal(){
        return this.produtoVendido.getPrecoProduto() * this.quantidade;
    }
}
