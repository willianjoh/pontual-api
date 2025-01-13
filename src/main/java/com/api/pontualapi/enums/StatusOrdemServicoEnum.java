package com.api.pontualapi.enums;

import lombok.Getter;

@Getter
public enum StatusOrdemServicoEnum {
    PENDENTE("PENDENTE"),
    CONCLUIDO( "CONCLUIDO"),
    CANCELADO("CANCELADO");
    public final String label;

    StatusOrdemServicoEnum(String label) {
        this.label = label;
    }
}
