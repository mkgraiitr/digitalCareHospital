package com.evooq.digitalCareHospital.service;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PatientManagerTest {
    PatientManager patientManager = new PatientManager();

    @Test
    void getPatientEndState() {
        Map<String, Long> patientEndStates = patientManager.getPatientEndState(HospitalTestUtil.getPatientList(), HospitalTestUtil.getDrugList());
        System.out.println(patientEndStates);
        assertEquals(3, patientEndStates.get("H"));
    }
}