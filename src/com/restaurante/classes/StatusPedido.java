package com.restaurante.classes;

public enum StatusPedido {
    EM_ANDAMENTO(0),
    PRONTO(1),
    ENTREGUE(2);

    private final int codigo;

    StatusPedido(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    //para converter o código de volta pro enum:
    public static StatusPedido fromCodigo(int codigo) {
        for (StatusPedido status : values()) {
            if (status.getCodigo() == codigo) {
                return status;
            }
        }
        throw new IllegalArgumentException("Código de status inválido: " + codigo);
    }
}