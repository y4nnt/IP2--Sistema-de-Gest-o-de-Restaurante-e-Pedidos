package com.restaurante.classes;

public class ItemVenda {
    private Produto produtoVendido;
    private int quantidade;
    private String observacaoPedido;

    public ItemVenda(Produto produtoVendido, int quantidade, String observacao) {
        this.produtoVendido = produtoVendido;

        if(quantidade < 0){
            this.quantidade = 0;
        }
        else{
            this.quantidade = quantidade;
        }

        this.observacaoPedido = observacao;
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

    public String getObservacaoPedido() {
        return observacaoPedido;
    }

    public void setObservacaoPedido(String observacaoPedido) {
        this.observacaoPedido = observacaoPedido;
    }

    public double calcularTotal(){
        return this.produtoVendido.getPrecoProduto() * this.quantidade;
    }

    public String toString(){
        return this.produtoVendido.toString() + "Quantidade: " + this.quantidade;
    }
}
