package com.nur.valueobjects;

import com.nur.core.BussinessRuleValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class NullRuleTest {

	@Mock
	NullRule nullRule;

	@BeforeEach
	void setUp() {
	}

	@Test
	void testOk() throws BussinessRuleValidationException {
		String entero = new String("obj");
		nullRule = new NullRule(entero);
		assertEquals(entero, nullRule.obj);
	}

	@Test
	void testFail() throws BussinessRuleValidationException {
		BussinessRuleValidationException exception = assertThrows(BussinessRuleValidationException.class,
				() -> new NullRule(null));
		assertEquals("Object can not be null", exception.getDetails());
	}

}