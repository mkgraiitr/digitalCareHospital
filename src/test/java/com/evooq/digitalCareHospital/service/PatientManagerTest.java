package com.evooq.digitalCareHospital.service;

import com.evooq.digitalCareHospital.engine.TreatmentImplementation;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatientManagerTest {
    HospitalManager hospitalManager = new HospitalManager();
    PatientManager patientManager = new PatientManager();

    @Test
    void getPatientEndState_happyScenario() {
        Map<String, Long> patientEndStates = patientManager.getPatientEndState(hospitalManager.
                getPrescription(HospitalTestUtil.getAllPatients(), HospitalTestUtil.getAllDrugs()));
        assertEquals(3, patientEndStates.get("H"));
        assertEquals(1, patientEndStates.get("X"));
        assertEquals(1, patientEndStates.get("D"));
    }

    @Test
    void getPatientEndState() {
        Map<String, Long> patientEndStates = patientManager.getPatientEndState(hospitalManager.
                getPrescription(HospitalTestUtil.getPatientList(), HospitalTestUtil.getDrugList()));
        assertEquals(3, patientEndStates.get("H"));
    }

    @Test
    void getPatientEndState_keep_diabeticPatients_Alive() {
        Map<String, Long> patientEndStates = patientManager.getPatientEndState(hospitalManager.
                getPrescription(HospitalTestUtil.getPatientListWithDiabetes(), HospitalTestUtil.getInsulin()));
        assertEquals(3, patientEndStates.get("D"));
    }

    @Test
    void getPatientEndState_cure_Tuberculosis_and_Fever() {
        Map<String, Long> patientEndStates = patientManager.getPatientEndState(hospitalManager.
                getPrescription(HospitalTestUtil.getPatientListWithMixedDiseases(), HospitalTestUtil.getMixedDoses()));
        assertEquals(2, patientEndStates.get("H"));
        assertEquals(1, patientEndStates.get("D"));
    }
}