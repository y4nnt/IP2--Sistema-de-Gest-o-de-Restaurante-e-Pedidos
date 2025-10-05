package com.restaurante.main;
import com.restaurante.classes.*;

public class Main {
    public static void main(String[] args) {
        Produto presunto = new Produto("Presunto",
                "Alimento frio",
                10.99,
                "Frios",
                true,
                "019");
        itemVenda presuntos = new itemVenda(presunto, 10);

        System.out.println(presuntos.calcularTotal());
    }
}
