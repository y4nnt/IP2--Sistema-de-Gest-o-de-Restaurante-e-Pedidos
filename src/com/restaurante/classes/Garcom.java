package com.restaurante.classes;

import java.util.ArrayList;
import java.util.List;

public class Garcom extends Usuario{
    private List<String> qualidadesGarcom;

    Garcom(String nomeUsuario, String cpf, String email, String telefone) {
        super(nomeUsuario, cpf, email, telefone);
        this.qualidadesGarcom = new ArrayList<>();
    }

    public void addHabilidadesGarcom (String habilidade){
        qualidadesGarcom.add(habilidade);
    }

    public void removerHabilidadesGarcom (String habilidade){
        qualidadesGarcom.remove(habilidade);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(String.format("Tipo: %-20s \n",
                this.getClass()));
        sb.append("Habilidades: ");
        for (String habilidade : qualidadesGarcom) {
            sb.append(String.format("-%s; ", habilidade));}

        return sb.toString();
    }
}
