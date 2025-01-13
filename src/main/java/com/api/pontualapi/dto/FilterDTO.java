package com.api.pontualapi.dto;

import com.api.pontualapi.enums.StatusOrdemServicoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Locale;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilterDTO {
    private String filter;

    public StatusOrdemServicoEnum getFilterEnum() {
        StatusOrdemServicoEnum status = null;
         if (filter != null) {

            if (filter.toUpperCase(Locale.ROOT).contains("PENDENTE")) {
                status = StatusOrdemServicoEnum.PENDENTE;
            }
            if (filter.toUpperCase(Locale.ROOT).contains("CONCLUIDO")) {
                status = StatusOrdemServicoEnum.CONCLUIDO;
            }
            if (filter.toUpperCase(Locale.ROOT).contains("CANCELADO")) {
                status = StatusOrdemServicoEnum.CANCELADO;
            }
        }
        return status;
    }
}
