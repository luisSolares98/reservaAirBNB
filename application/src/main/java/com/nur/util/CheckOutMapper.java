package com.nur.util;

import com.nur.core.BussinessRuleValidationException;
import com.nur.dtos.CheckOutDTO;
import com.nur.model.CheckOut;
import java.util.UUID;

public class CheckOutMapper {
    public static CheckOutDTO from(CheckOut checkOut) {
        if (checkOut == null) return CheckOutDTO.builder().build();
        return CheckOutDTO.builder()
                .reserveId(checkOut.getReserveID().toString())
                .dateTimeCheckOut(checkOut.getDateTimeCheckOut())
                .typeCheckOut(checkOut.getTypeCheckOut())
                .checkOutId(checkOut.getKey().toString())
                .build();
    }

    public static CheckOut from(CheckOutDTO checkOutDTO)
            throws BussinessRuleValidationException {
        return new CheckOut(checkOutDTO.getDateTimeCheckOut(), checkOutDTO.getTypeCheckOut(), UUID.fromString(checkOutDTO.getReserveId()));
    }
}
