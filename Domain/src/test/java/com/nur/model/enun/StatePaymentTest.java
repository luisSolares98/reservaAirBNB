package com.nur.model.enun;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
@ExtendWith(MockitoExtension.class)
class StatePaymentTest {

    @BeforeEach
    void setUp() {
    }
    @Test
    void testEnumValues() {
        assertEquals("INIT", StatePayment.INIT.name());
        assertEquals("FINAL", StatePayment.FINAL.name());
        assertEquals("CANCEL", StatePayment.CANCEL.name());
    }

    @Test
    void testEnumValuesInequality() {
        assertNotEquals(StatePayment.INIT, StatePayment.FINAL);
        assertNotEquals(StatePayment.INIT, StatePayment.CANCEL);
        assertNotEquals(StatePayment.FINAL, StatePayment.CANCEL);
    }
}