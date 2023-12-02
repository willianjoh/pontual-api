package com.api.pontualapi.enums;

import lombok.Getter;

@Getter
public enum StatusPagamentoEnum {
    PAGAMENTO_PENDENTE(1, "Pagamento pendente"),
    PAGO(2, "Pagamento realizado");
    public final Integer code;
    public final String label;

    StatusPagamentoEnum(Integer code, String label) {
        this.code = code;
        this.label = label;
    }
}
