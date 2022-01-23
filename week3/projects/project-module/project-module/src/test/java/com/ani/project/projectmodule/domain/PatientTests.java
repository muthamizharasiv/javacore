package com.ani.project.projectmodule.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PatientTests {
    @DisplayName("Domain : Checking Object Creation")
    @Test
    void testObjectCreation(){
        var patient = new Patient();
        Assertions.assertNotNull(patient);
    }
    @DisplayName("Domain : Checking getters and setters")
    @Test
    void testObjectGettersSetters(){
        var patient = new Patient();
        patient.setName("patient");
        patient.setId(10);


        Assertions.assertEquals("patient",patient.getName());
        Assertions.assertEquals(10,patient.getId());

    }
}
