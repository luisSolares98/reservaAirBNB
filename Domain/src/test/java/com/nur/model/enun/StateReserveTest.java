package com.nur.model.enun;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class StateReserveTest {

    @BeforeEach
    void setUp() {
    }
    @Test
    void testEnumValues() {
        assertEquals("RERSERVE", StateReserve.RERSERVE.name());
        assertEquals("FINAL", StateReserve.FINAL.name());
        assertEquals("CANCEL", StateReserve.CANCEL.name());
    }

    @Test
    void testEnumValuesInequality() {
        assertNotEquals(StateReserve.RERSERVE, StateReserve.FINAL);
        assertNotEquals(StateReserve.FINAL, StateReserve.CANCEL);
        assertNotEquals(StateReserve.FINAL, StateReserve.RERSERVE);
    }
}