package com.restaurante.classes;
import java.util.ArrayList;
import java.util.List;

public class RepositorioMesa {
    private List<Mesa> mesas;

    public RepositorioMesa() {
        mesas = new ArrayList<>();
    }

    public void addMesa(Mesa mesa) {
        mesas.add(mesa);
    }

    public void removerMesa(Mesa mesa) {
        mesas.remove(mesa);
    }

    public Mesa getMesa(int numeroMesa) {
        for (Mesa mesa : mesas) {
            if (mesa.getNumeroMesa() == numeroMesa) {
                return mesa;
            }
        }
        return null;
    }

    public List<Mesa> getMesas() {
        return mesas;
    }
}
