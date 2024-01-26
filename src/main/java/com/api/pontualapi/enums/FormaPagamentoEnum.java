package com.api.pontualapi.enums;

import lombok.Getter;

@Getter
public enum FormaPagamentoEnum {
    DINHEIRO("Dinheiro"),
    DEBITO("Débito"),
    CREDITO("Crédito"),
    PIX( "Pix");
    public final String label;
    FormaPagamentoEnum(String label) {
        this.label = label;
    }
}
