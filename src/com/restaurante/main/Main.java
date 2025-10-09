package com.restaurante.main;
import com.restaurante.classes.*;

public class Main {
    public static void main(String[] args) {
        Produto presunto = new Produto("Presunto",
                "Alimento frio",
                10.99,
                CategoriaProduto.ENTRADA,
                StatusProduto.DISPONIVEL,
                "019");
        Produto queijo = new Produto("Queijo",
                "Alimento frio",
                17.99,
                CategoriaProduto.ENTRADA,
                StatusProduto.DISPONIVEL,
                "020");
        ItemVenda presuntos = new ItemVenda(presunto, 10, "sem queijo");
        Cardapio cardapio = new Cardapio();

        cardapio.addItem(presunto);
        System.out.println("Codigo do item procurado: " + cardapio.buscarItem("019"));

        System.out.println(presuntos.calcularTotal());
    }
}
