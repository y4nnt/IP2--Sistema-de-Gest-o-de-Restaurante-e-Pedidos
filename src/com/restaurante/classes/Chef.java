package com.restaurante.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Chef extends Usuario {
    private List<Produto> pratoEspecialidades;

    public Chef(String nomeUsuario, String cpf, String email, String telefone) {
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
        sb.append(super.toString());

        // 1. Use Streams para extrair os nomes dos pratos e juntá-los em uma única String.
        // Isso é mais eficiente e limpo que um loop para essa tarefa.
        String especialidadesFormatadas = pratoEspecialidades.stream()
                .map(Produto::getNomeProduto) // Pega o nome de cada produto
                .collect(Collectors.joining(", ")); // Junta com ", "

        // 2. Agora, formate as linhas completas com os dados já preparados.
        sb.append(String.format("| %-15s | %-30s %n", "Tipo", "Chef"));
        sb.append(String.format("| %-15s | %-30s %n", "Especialidades", especialidadesFormatadas));

        return sb.toString();
    }
}
