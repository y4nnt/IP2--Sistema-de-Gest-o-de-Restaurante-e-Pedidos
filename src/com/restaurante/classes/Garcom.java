package com.restaurante.classes;

import java.util.ArrayList;
import java.util.List;

public class Garcom extends Usuario{
    private List<String> qualidadesGarcom;

    public Garcom(String nomeUsuario, String cpf, String email, String telefone) {
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
        sb.append(super.toString()); // Chama a versão corrigida da classe pai

        // Junta todas as habilidades em uma única string, separadas por ", "
        String habilidadesFormatadas = String.join(", ", qualidadesGarcom);

        // LINHA 3: Tipo
        sb.append(String.format("| %-15s | %-30s %n", "Tipo", "Garçom"));

        // LINHA 4: Habilidades
        sb.append(String.format("| %-15s | %-30s %n", "Habilidades", habilidadesFormatadas));

        return sb.toString();
    }
}
