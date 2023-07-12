package com.api.pontualapi.enums;

import lombok.Getter;

@Getter
public enum TipoOperacaoEnum {
    VENDA(1, "Venda"),
    SERVICO(2, "Serviço");
    public final Integer code;
    public final String label;

    TipoOperacaoEnum(Integer code, String label) {
        this.code = code;
        this.label = label;
    }
}
