package com.nur.modal.enun;

import lombok.Getter;

@Getter
public enum StateReserve {
    RERSERVE("Reservado"),
    FINAL("Finalizado"),
    CANCEL("Canceldo");
    private final String state;

    StateReserve(String state) {
        this.state = state;
    }
}
