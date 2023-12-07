package com.nur.valueobjects;

import com.nur.core.BussinessRuleValidationException;
import com.nur.core.ValueObject;
import com.nur.rules.ObjNotNull;

public class NullRule extends ValueObject {

	Object obj;

	public NullRule(Object obj) throws BussinessRuleValidationException {
		CheckRule(new ObjNotNull(obj));
		this.obj = obj;
	}

}
