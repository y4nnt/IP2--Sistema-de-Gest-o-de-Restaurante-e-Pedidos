package com.restaurante.classes;

public abstract class Usuario {
    private String nomeUsuario;
    private String cpf;
    private String email;
    private String telefone;

    public Usuario(String nomeUsuario, String cpf, String email, String telefone) {
        this.nomeUsuario = nomeUsuario;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }

    public String formatarTelefone() {
        String numeroLimpo = this.telefone.replaceAll("\\D", "");

        if (numeroLimpo.length() == 11) {
            return String.format("(%s) %s-%s",
                    numeroLimpo.substring(0, 2),
                    numeroLimpo.substring(2, 7),
                    numeroLimpo.substring(7, 11)
            );
        } else if (numeroLimpo.length() == 10) {
            return String.format("(%s) %s-%s",
                    numeroLimpo.substring(0, 2),
                    numeroLimpo.substring(2, 6),
                    numeroLimpo.substring(6, 10)
            );
        } else {

            return telefone;
        }
    }

    public String getNomeUsuario(){
        return this.nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String emailUsuario) {
        this.email = emailUsuario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        // LINHA 1: Nome e CPF
        sb.append(String.format("| %-15s | %-30s %n", "Usuário", this.nomeUsuario));
        sb.append(String.format("| %-15s | %-30s %n", "CPF", this.cpf));

        // LINHA 2: Contato
        sb.append(String.format("| %-15s | %-30s %n", "Telefone", this.formatarTelefone()));
        sb.append(String.format("| %-15s | %-30s %n", "Email", this.email));

        return sb.toString();
    }

}
