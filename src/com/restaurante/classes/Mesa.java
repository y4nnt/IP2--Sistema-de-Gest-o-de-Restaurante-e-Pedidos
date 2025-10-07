package com.restaurante.classes;

public class Mesa {
    private int numeroMesa;
    private boolean statusMesa; // true = ocupada, false = livre
    private int capacidadeMesa;
    private int numeroUso;
    private static RepositorioMesa repositorioMesa = new RepositorioMesa();

    public Mesa(int numeroMesa, boolean statusMesa, int capacidadeMesa) {
        setNumeroMesa(numeroMesa);
        setStatusMesa(statusMesa);
        setCapacidadeMesa(capacidadeMesa);
        this.numeroUso = 0;
        repositorioMesa.addMesa(this);
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        if (numeroMesa <= 0) {
            throw new IllegalArgumentException("O número da mesa deve ser maior que zero.");
        } else if(numeroMesa != this.numeroMesa && repositorioMesa.getMesa(numeroMesa) != null) {
            throw new IllegalArgumentException("Já existe uma mesa com esse número.");
        }
        this.numeroMesa = numeroMesa;
    }

    public boolean isStatusMesa() {
        return statusMesa;
    }

    public void setStatusMesa(boolean statusMesa) {
        this.statusMesa = statusMesa;
    }

    public int getCapacidadeMesa() {
        return capacidadeMesa;
    }

    public void setCapacidadeMesa(int capacidadeMesa) {
        this.capacidadeMesa = capacidadeMesa;
    }

    public int getNumeroUso() {
        return numeroUso;
    }

    public void addNumeroUso() {
        this.numeroUso += 1;
    }
}
