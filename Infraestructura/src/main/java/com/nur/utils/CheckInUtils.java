package com.nur.utils;

import com.nur.annotations.Generated;
import com.nur.core.BussinessRuleValidationException;
import com.nur.model.CheckIn;
import com.nur.model.CheckInJapModel;

import java.util.Collections;
import java.util.List;
@Generated
public class CheckInUtils {
    public static List<CheckInJapModel> checkInJpaModelList(
            List<CheckIn> checkIns
    ) {
        if (checkIns == null) return Collections.emptyList();
        return checkIns
                .stream()
                .map((CheckIn checkIn) -> checkInToJpaEntity(checkIn))
                .toList();
    }
    public static CheckInJapModel checkInToJpaEntity(
            CheckIn checkIn
    ) {
        CheckInJapModel model = new CheckInJapModel();
        model.setId(checkIn.getKey());
        model.setDateTimeCheckIn(checkIn.getDateTimeCheckIn());
        model.setTypeCheckIn(checkIn.getTypeCheckIn());
        model.setReserveID(checkIn.getReserveID());
        return model;
    }
    public static CheckIn jpaToCheckIn(CheckInJapModel jpaModel)
            throws BussinessRuleValidationException {

        return new CheckIn(jpaModel.getId(), jpaModel.getDateTimeCheckIn(), jpaModel.getTypeCheckIn(), jpaModel.getReserveID());
    }
}
