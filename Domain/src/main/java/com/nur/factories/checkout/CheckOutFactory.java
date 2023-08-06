package com.nur.factories.checkout;

import com.nur.model.CheckOut;

import java.util.Date;
import java.util.UUID;

public class CheckOutFactory implements ICheckOutFactory {

  @Override
  public CheckOut create(Date dateTimeCheckOut, String typeCheckOut, UUID reserveID) {
    return CheckOut.builder().dateTimeCheckOut(dateTimeCheckOut).typeCheckOut(typeCheckOut).reserveID(reserveID).build();
  }
}
