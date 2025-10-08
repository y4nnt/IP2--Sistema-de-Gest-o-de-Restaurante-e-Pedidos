package com.restaurante.classes;

public enum StatusProduto {
    INDISPONIVEL(0),
    DISPONIVEL(1);

    private final int codigo;

    StatusProduto(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
    //para converter de novo para enum
    public static StatusProduto fromCodigo(int codigo) {
        for (StatusProduto status : values()) {
            if (status.getCodigo() == codigo) {
                return status;
            }
        }
        throw new IllegalArgumentException("Código de status de produto inválido: " + codigo);
    }
}

