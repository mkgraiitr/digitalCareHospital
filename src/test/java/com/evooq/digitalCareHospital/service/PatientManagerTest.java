package com.evooq.digitalCareHospital.service;

import com.evooq.digitalCareHospital.engine.ImmatureStrategy;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatientManagerTest {
    PatientManager patientManager = new PatientManager();

    @Test
    void getPatientEndState_happyScenario() {
        DigitalDoctor digitalDoctor = new DigitalDoctor();
        ImmatureStrategy immatureStrategy = new ImmatureStrategy();
        digitalDoctor.setTreatmentStrategy(immatureStrategy);
        Map<String, Long> patientEndStates = patientManager.getPatientEndState(digitalDoctor.
                getPrescription(HospitalTestUtil.getAllPatients(), HospitalTestUtil.getAllDrugs()));
        System.out.println(patientEndStates);
        assertEquals(3, patientEndStates.get("H"));
        assertEquals(1, patientEndStates.get("X"));
        assertEquals(1, patientEndStates.get("D"));
    }

    @Test
    void getPatientEndState() {
        DigitalDoctor digitalDoctor = new DigitalDoctor();
        ImmatureStrategy immatureStrategy = new ImmatureStrategy();
        digitalDoctor.setTreatmentStrategy(immatureStrategy);
        Map<String, Long> patientEndStates = patientManager.getPatientEndState(digitalDoctor.
                getPrescription(HospitalTestUtil.getPatientList(), HospitalTestUtil.getDrugList()));
        System.out.println(patientEndStates);
        assertEquals(3, patientEndStates.get("H"));
    }

    @Test
    void getPatientEndState_keep_diabeticPatients_Alive() {
        DigitalDoctor digitalDoctor = new DigitalDoctor();
        ImmatureStrategy immatureStrategy = new ImmatureStrategy();
        digitalDoctor.setTreatmentStrategy(immatureStrategy);
        Map<String, Long> patientEndStates = patientManager.getPatientEndState(digitalDoctor.
                getPrescription(HospitalTestUtil.getPatientListWithDiabetes(), HospitalTestUtil.getInsulin()));
        System.out.println(patientEndStates);
        assertEquals(3, patientEndStates.get("D"));
    }

    @Test
    void getPatientEndState_cure_Tuberculosis_and_Fever() {
        DigitalDoctor digitalDoctor = new DigitalDoctor();
        ImmatureStrategy immatureStrategy = new ImmatureStrategy();
        digitalDoctor.setTreatmentStrategy(immatureStrategy);
        Map<String, Long> patientEndStates = patientManager.getPatientEndState(digitalDoctor.
                getPrescription(HospitalTestUtil.getPatientListWithMixedDiseases(), HospitalTestUtil.getMixedDoses()));
        System.out.println(patientEndStates);
        assertEquals(2, patientEndStates.get("H"));
        assertEquals(1, patientEndStates.get("D"));
    }
}