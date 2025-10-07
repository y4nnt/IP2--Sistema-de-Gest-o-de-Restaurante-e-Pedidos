package com.restaurante.classes;

import java.util.ArrayList;
import java.util.List;

public class Chef extends Usuario {
    private List<Produto> pratoEspecialidades;

    Chef(String nomeUsuario, String cpf, String email, String telefone) {
        super(nomeUsuario, cpf, email, telefone);
        this.pratoEspecialidades = new ArrayList<>();
    }

    public void addPratoEspecialidade (Produto prato){
        pratoEspecialidades.add(prato);
    }

    public void removerPratoEspecialidade (Produto prato){
        pratoEspecialidades.remove(prato);
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Tipo: %-20s \n",
                this.getClass()));
        sb.append(String.format("Pratos de especialidades: "));
        for (Produto prato : pratoEspecialidades) {
            sb.append(String.format("-%s; ", prato));}
        return super.toString() + sb.toString();
    }
}
