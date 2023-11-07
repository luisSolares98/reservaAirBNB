package com.nur.util;

import com.nur.core.BussinessRuleValidationException;
import com.nur.dtos.ReserveDTO;
import com.nur.model.Reserve;

public class ReserveInMapper {
    public static ReserveDTO from(Reserve reserve) {
        if (reserve == null) return ReserveDTO.builder().build();
        return ReserveDTO.builder()
                .reserveID(reserve.getKey().toString())
                .dateIn(reserve.getDateIn())
                .dateOut(reserve.getDateOut())
                .state(reserve.getState())
                .build();
    }

    public static Reserve from(ReserveDTO reserveDTO)
            throws BussinessRuleValidationException {
        return new Reserve(reserveDTO.getDateIn(), reserveDTO.getState(), reserveDTO.getDateOut(), reserveDTO.getPublishID());
    }
}
