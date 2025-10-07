package com.restaurante.classes;

public class Garcom extends Usuario{

    Garcom(String nomeUsuario, String cpf, String email, String telefone) {
        super(nomeUsuario, cpf, email, telefone);
    }

    public String relatorioGarcom(){
        return "a";
    }

    @Override
    public String toString() {
        return super.toString() + "Tipo: " + this.getClass();
    }
}
