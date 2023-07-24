package com.nur.modal.enun;

import lombok.Getter;

@Getter
public enum StatePayment {
    RERSERVE("Pago Iniciado"),
    FINAL("Pago Finalizado"),
    CANCEL("pago Canceldo");
    private final String state;

    StatePayment(String state) {
        this.state = state;
    }
}
