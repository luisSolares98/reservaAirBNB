package com.nur.utils;

import com.nur.core.BussinessRuleValidationException;
import com.nur.exceptions.InvalidDataException;
import com.nur.model.Reserve;
import com.nur.model.ReserveJpaModel;
import com.nur.valueobjects.NullRule;

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
        model.setPublishID(reserva.getPublishID());
        return model;
    }
    public static Reserve jpaToreserva(ReserveJpaModel jpaModel)
            throws BussinessRuleValidationException {
        if (jpaModel == null) {
            throw new InvalidDataException("Data Not Found");
        }
        return new Reserve(jpaModel.getId(),jpaModel.getDateIn(), jpaModel.getState(), jpaModel.getDateOut(), jpaModel.getPublishID());
    }
}
