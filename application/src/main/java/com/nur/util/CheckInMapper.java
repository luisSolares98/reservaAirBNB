package com.nur.util;

import com.nur.core.BussinessRuleValidationException;
import com.nur.dtos.CheckInDTO;
import com.nur.model.CheckIn;
import java.util.UUID;

public class CheckInMapper {
    public static CheckInDTO from(CheckIn checkIn) {
        if (checkIn == null) return CheckInDTO.builder().build();
        return CheckInDTO.builder()
                .reserveId(checkIn.getReserveID().toString())
                .dateTimeCheckIn(checkIn.getDateTimeCheckIn())
                .typeCheckIn(checkIn.getTypeCheckIn())
                .checkInId(checkIn.getKey().toString())
                .build();
    }

    public static CheckIn from(CheckInDTO checkInDTO)
            throws BussinessRuleValidationException {
        return new CheckIn(checkInDTO.getDateTimeCheckIn(), checkInDTO.getTypeCheckIn(), UUID.fromString(checkInDTO.getReserveId()) );
    }
}
