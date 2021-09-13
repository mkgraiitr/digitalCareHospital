package com.evooq.digitalCareHospital.service;

import com.evooq.digitalCareHospital.engine.ImmatureStrategy;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PatientManagerTest {
    PatientManager patientManager = new PatientManager();

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
}