package com.restaurante.classes;

import java.util.ArrayList;
import java.util.List;

public class Garcom extends Usuario{
    private List<String> habilidadesGarcom;

    Garcom(String nomeUsuario, String cpf, String email, String telefone) {
        super(nomeUsuario, cpf, email, telefone);
        this.habilidadesGarcom = new ArrayList<>();
    }

    public void addHabilidadesGarcom (String habilidade){
        habilidadesGarcom.add(habilidade);
    }

    public void removerHabilidadesGarcom (String habilidade){
        habilidadesGarcom.remove(habilidade);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Tipo: %-20s \n",
                this.getClass()));
        sb.append("Habilidades: ");
        for (String habilidade : habilidadesGarcom) {
            sb.append(String.format("-%s; ", habilidade));}

        return super.toString() + sb.toString();
    }
}
