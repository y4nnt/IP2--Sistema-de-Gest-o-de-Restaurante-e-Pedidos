package com.restaurante.classes;

public class Chef extends Usuario {

    Chef(String nomeUsuario, String cpf, String email, String telefone) {
        super(nomeUsuario, cpf, email, telefone);
    }

    @Override
    public String toString(){
        return super.toString() + "Tipo: " + this.getClass();
    }
}
