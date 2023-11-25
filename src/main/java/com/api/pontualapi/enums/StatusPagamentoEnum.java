package com.api.pontualapi.enums;

import lombok.Getter;

@Getter
public enum StatusPagamentoEnum {
    PAGO(1, "Pago"),
    PAGAMENTO_PENDENTE(2, "Pagamento pendente");
    public final Integer code;
    public final String label;

    StatusPagamentoEnum(Integer code, String label) {
        this.code = code;
        this.label = label;
    }
}
