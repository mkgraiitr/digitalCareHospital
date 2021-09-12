package com.evooq.digitalCareHospital.service;

import com.evooq.digitalCareHospital.domain.Hospital;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class HospitalManagerTest {
    HospitalManager hospitalManager = new HospitalManager();
    PatientManager patientManager = new PatientManager();

    @Test
    void integrationTest_getFeverCured_allPatient() {
        Hospital hospital = hospitalManager.buildHospitalDetails("F,F,F P,P,P");
        Map<String, Long> patientEndStates = patientManager.getPatientEndState(hospital.getPatients(), hospital.getDrugList());
        System.out.println(patientEndStates);
        assertEquals(3, patientEndStates.get("H"));
    }

    @Test
    void integrationTest_dead_diabeticPatient() {
        Hospital hospital = hospitalManager.buildHospitalDetails("D,D");
        Map<String, Long> patientEndStates = patientManager.getPatientEndState(hospital.getPatients(), hospital.getDrugList());
        System.out.println(patientEndStates);
        assertEquals(2, patientEndStates.get("X"));
        assertNotEquals(2, patientEndStates.get("H"));
    }

    @Test
    void integrationTest_shortageOfDrugs() {
        Hospital hospital = hospitalManager.buildHospitalDetails("F,F,F P");
        Map<String, Long> patientEndStates = patientManager.getPatientEndState(hospital.getPatients(), hospital.getDrugList());
        System.out.println(patientEndStates);
        assertEquals(1, patientEndStates.get("H"));
        assertEquals(2, patientEndStates.get("F"));
        assertNotEquals(1, patientEndStates.get("D"));
    }


}