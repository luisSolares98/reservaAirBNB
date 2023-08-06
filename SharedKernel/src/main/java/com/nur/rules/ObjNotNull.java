package com.nur.rules;


import com.nur.core.BussinessRule;

public class ObjNotNull implements BussinessRule {

  private final Object value;

  public ObjNotNull(Object value) {
    this.value = value;
  }

  @Override
  public boolean isValid() {
    return value != null;
  }

  @Override
  public String message() {
    return "Object can not be null";
  }
}
