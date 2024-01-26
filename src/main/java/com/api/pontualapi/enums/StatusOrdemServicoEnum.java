package com.api.pontualapi.enums;

import lombok.Getter;

@Getter
public enum StatusOrdemServicoEnum {
    INICIADO("INICIADO"),
    PENDENTE("PENDENTE"),
    FINALIZADO( "FINALIZADO"),
    CANCELADO("CANCELADO");
    public final String label;

    StatusOrdemServicoEnum(String label) {
        this.label = label;
    }
}
