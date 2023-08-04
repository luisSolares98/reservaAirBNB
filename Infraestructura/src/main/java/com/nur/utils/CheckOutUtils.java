package com.nur.utils;

import com.nur.core.BussinessRuleValidationException;
import com.nur.modal.CheckOut;
import com.nur.model.CheckOutJapModel;
import java.util.Collections;
import java.util.List;

public class CheckOutUtils {
    public static List<CheckOutJapModel> checkOutJpaModelList(
            List<CheckOut> checkOuts
    ) {
        if (checkOuts == null) return Collections.emptyList();
        return checkOuts
                .stream()
                .map((CheckOut checkOut) -> checkOutToJpaEntity(checkOut))
                .toList();
    }
    public static CheckOutJapModel checkOutToJpaEntity(
            CheckOut checkOut
    ) {
        CheckOutJapModel model = new CheckOutJapModel();
        model.setId(checkOut.getKey());
        model.setDateTimeCheckIn(checkOut.getDateTimeCheckIn());
        model.setTypeCheckIn(checkOut.getTypeCheckIn());
        model.setReserveID(checkOut.getReserveID());
        return model;
    }
    public static CheckOut jpaToCheckOut(CheckOutJapModel jpaModel)
            throws BussinessRuleValidationException {
        return new CheckOut(jpaModel.getDateTimeCheckIn(), jpaModel.getTypeCheckIn(), jpaModel.getReserveID());
    }
}
