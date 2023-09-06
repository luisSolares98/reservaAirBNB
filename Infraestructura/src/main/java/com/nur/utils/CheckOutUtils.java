package com.nur.utils;

import com.nur.core.BussinessRuleValidationException;
import com.nur.exceptions.InvalidDataException;
import com.nur.model.CheckOut;
import com.nur.model.CheckOutJapModel;
import com.nur.valueobjects.NullRule;

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
        model.setDateTimeCheckOut(checkOut.getDateTimeCheckOut());
        model.setTypeCheckOut(checkOut.getTypeCheckOut());
        model.setReserveID(checkOut.getReserveID());
        return model;
    }
    public static CheckOut jpaToCheckOut(CheckOutJapModel jpaModel)
            throws BussinessRuleValidationException {
        if (jpaModel == null) {
            throw new InvalidDataException("Data Not Found");
        }
        return new CheckOut(jpaModel.getId(), jpaModel.getDateTimeCheckOut(), jpaModel.getTypeCheckOut(), jpaModel.getReserveID());
    }
}
