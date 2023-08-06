package com.nur.utils;

import com.nur.core.BussinessRuleValidationException;
import com.nur.model.Reserve;
import com.nur.model.ReserveJpaModel;

import java.util.Collections;
import java.util.List;

public class ReserveUtils {
    public static List<ReserveJpaModel> reserveJpaModelList(
            List<Reserve> reservas
    ) {
        if (reservas == null) return Collections.emptyList();
        return reservas
                .stream()
                .map((Reserve reserva) -> reservaToJpaEntity(reserva))
                .toList();
    }
    public static ReserveJpaModel reservaToJpaEntity(Reserve reserva) {
        ReserveJpaModel model = new ReserveJpaModel();
        model.setId(reserva.getKey());
        model.setState(reserva.getState().toString());
        model.setDateIn(reserva.getDateIn());
        model.setDateOut(reserva.getDateOut());
        return model;
    }
    public static Reserve jpaToreserva(ReserveJpaModel jpaModel)
            throws BussinessRuleValidationException {
        return Reserve.builder().dateIn(jpaModel.getDateIn()).dateOut(jpaModel.getDateOut()).state(jpaModel.getState()).build();
    }
}
