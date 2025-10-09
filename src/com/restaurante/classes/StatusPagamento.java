package com.restaurante.classes;

public enum StatusPagamento {
    ABERTO(0),
    EM_PROCESSAMENTO(1),
    PAGO(2);

    private final int codigo;

    StatusPagamento(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    //para converter o código de volta pro enum:
    public static StatusPagamento fromCodigo(int codigo) {
        for (StatusPagamento status : values()) {
            if (status.getCodigo() == codigo) {
                return status;
            }
        }
        throw new IllegalArgumentException("Código de status inválido: " + codigo);
    }
}