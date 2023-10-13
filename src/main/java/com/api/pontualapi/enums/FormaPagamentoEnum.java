package com.api.pontualapi.enums;

import lombok.Getter;

@Getter
public enum FormaPagamentoEnum {
    DINHEIRO(1, "Dinheiro"),
    DEBITO(2, "Débito"),
    CREDITO(3, "Crédito"),
    PIX(4, "Pix");

    public final Integer code;
    public final String label;

    FormaPagamentoEnum(Integer code, String label) {
        this.code = code;
        this.label = label;
    }
}
