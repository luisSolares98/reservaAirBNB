package com.nur.rules;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObjNotNullTest {
    @Spy
    @InjectMocks
    ObjNotNull obj;
    @Mock
    Object value;
    @BeforeEach
    void setUp() {
    }

    @Test
    void objectNotNull() {

        when(obj.isValid()).thenReturn(false);
        boolean bandera = obj.isValid();
        assertNotNull(bandera);

    }
}