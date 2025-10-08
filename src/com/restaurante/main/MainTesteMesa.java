package com.restaurante.main;
import com.restaurante.classes.*;

public class MainTesteMesa {
    public static void main(String[] args) {
        Mesa mesa1 = new Mesa(1, StatusMesa.LIVRE, 4);
        Mesa mesa2 = new Mesa(2, StatusMesa.LIVRE, 2);
        Mesa mesa3 = new Mesa(3, StatusMesa.LIVRE, 6);

        System.out.println("Número da Mesa 1: " + mesa1.getNumeroMesa());
        System.out.println("Status da Mesa 1 (true = ocupada, false = livre): " + mesa1.isStatusMesa());
        System.out.println("Capacidade da Mesa 1: " + mesa1.getCapacidadeMesa());
        System.out.println("Número de Uso da Mesa 1: " + mesa1.getNumeroUso());


        
        mesa3.setNumeroMesa(4); // Alteração para um número não existente
        mesa2.setNumeroMesa(1); // Tentativa de alterar para um número já existente
    } 
}
