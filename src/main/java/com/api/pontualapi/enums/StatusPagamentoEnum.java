package com.api.pontualapi.enums;

import lombok.Getter;

@Getter
public enum StatusPagamentoEnum {
    PENDENTE("PENDENTE"),
    PAGO("PAGO");

    public final String label;

    StatusPagamentoEnum(String label) {
        this.label = label;
    }
}
