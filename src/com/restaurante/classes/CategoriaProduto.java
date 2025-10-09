package com.restaurante.classes;

public enum CategoriaProduto {
    ENTRADA(0),
    PRINCIPAL(1),
    SOBREMESA(2),
    BEBIDA(3);
    private final int codigo;

    CategoriaProduto(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    //para converter o código de volta pro enum:
    public static CategoriaProduto fromCodigo(int codigo) {
        for (CategoriaProduto status : values()) {
            if (status.getCodigo() == codigo) {
                return status;
            }
        }
        throw new IllegalArgumentException("Código de produto inválido: " + codigo);
    }
}