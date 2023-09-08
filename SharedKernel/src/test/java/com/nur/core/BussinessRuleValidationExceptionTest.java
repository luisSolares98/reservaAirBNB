package com.nur.core;

import com.nur.rules.ObjNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class BussinessRuleValidationExceptionTest {

    @Spy
    BussinessRule brokenRule;
    @Mock
    BussinessRuleValidationException exception;

    @Mock
    ValueObject valueObject;
    @BeforeEach
    void setUp() {
        exception = new BussinessRuleValidationException("Error", "Test");
        ReflectionTestUtils.setField(exception, "brokenRule", null);
        ReflectionTestUtils.setField(exception, "details", "test prueba");
        valueObject = new ValueObject() {
            @Override
            protected void CheckRule(BussinessRule rule) throws BussinessRuleValidationException {
                super.CheckRule(rule);
            }
        };

    }

    @Test
    void testToString() {
        exception = new BussinessRuleValidationException(new ObjNotNull(2));
        String toString  = exception.toString();
        assertEquals("com.nur.rules.ObjNotNull:Object can not be null", toString.toString());
    }

    @Test
    void getBrokenRule() {
        exception = new BussinessRuleValidationException(new ObjNotNull(2));
        BussinessRule rule = exception.getBrokenRule();
        assertEquals(rule.getClass().getName(), "com.nur.rules.ObjNotNull");
    }

    @Test
    void getDetails() {
        String toString  = exception.toString();
        assertEquals("BussinessRule:test prueba", toString.toString());
    }

    @Test
    void checkRuleNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> valueObject.CheckRule(null)) ;
        assertEquals("Rule cannot be null", exception.getMessage());
    }
}