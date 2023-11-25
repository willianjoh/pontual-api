package com.api.pontualapi.enums;

import lombok.Getter;

@Getter
public enum StatusOrdemServicoEnum {
    EM_ANDAMENTO(1, "Em andamento"),
    DISPONIVEL_RETIRADA(2, "Disponível para retirada"),
    ENTREGUE(3, "Entregue");
    public final Integer code;
    public final String label;

    StatusOrdemServicoEnum(Integer code, String label) {
        this.code = code;
        this.label = label;
    }
}
