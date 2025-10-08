package com.restaurante.classes;

public enum StatusMesa {
    OCUPADA(0),
    LIVRE(1);

    private final int codigo;

    StatusMesa(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static StatusMesa fromCodigo(int codigo) {
        for (StatusMesa status : values()) {
            if (status.getCodigo() == codigo) {
                return status;
            }
        }
        throw new IllegalArgumentException("Código de status de mesa inválido: " + codigo);
    }
}
