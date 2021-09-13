package com.evooq.digitalCareHospital.service;

import com.evooq.digitalCareHospital.domain.Hospital;
import com.evooq.digitalCareHospital.domain.PrescriptionDetails;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class HospitalManagerTest {
    HospitalManager hospitalManager = new HospitalManager();
    PatientManager patientManager = new PatientManager();

    @Test
    void integrationTest_getFeverCured_allPatient() {
        Hospital hospital = hospitalManager.buildHospitalDetails("F,F,F P,P,P");
        List<PrescriptionDetails> prescriptions = hospital.getDoctors().get(0).getPrescription(hospital.getPatients(), hospital.getDrugList());
        Map<String, Long> patientEndStates = patientManager.getPatientEndState(prescriptions);
        assertEquals(3, patientEndStates.get("H"));
    }

    @Test
    void integrationTest_dead_diabeticPatient() {
        Hospital hospital = hospitalManager.buildHospitalDetails("D,D");
        List<PrescriptionDetails> prescriptions = hospital.getDoctors().get(0).getPrescription(hospital.getPatients(), hospital.getDrugList());
        Map<String, Long> patientEndStates = patientManager.getPatientEndState(prescriptions);
        assertEquals(2, patientEndStates.get("X"));
        assertNotEquals(2, patientEndStates.get("H"));
    }

    @Test
    void integrationTest_shortageOfDrugs() {
        Hospital hospital = hospitalManager.buildHospitalDetails("F,F,F P");
        List<PrescriptionDetails> prescriptions = hospital.getDoctors().get(0).getPrescription(hospital.getPatients(), hospital.getDrugList());
        Map<String, Long> patientEndStates = patientManager.getPatientEndState(prescriptions);
        assertEquals(1, patientEndStates.get("H"));
        assertEquals(2, patientEndStates.get("F"));
        assertNotEquals(1, patientEndStates.get("D"));
    }

    @Test
    void integrationTest_onePatient_manuDrugs() {
        Hospital hospital = hospitalManager.buildHospitalDetails("F P,P,As,I,An");
        List<PrescriptionDetails> prescriptions = hospital.getDoctors().get(0).getPrescription(hospital.getPatients(), hospital.getDrugList());
        Map<String, Long> patientEndStates = patientManager.getPatientEndState(prescriptions);
        assertEquals(1, patientEndStates.get("H"));
        assertNull(patientEndStates.get("F"));
        assertNull(patientEndStates.get("D"));
    }

    @Test
    void integrationTest_healthyPatients_noDrugs() {
        Hospital hospital = hospitalManager.buildHospitalDetails("H,H");
        List<PrescriptionDetails> prescriptions = hospital.getDoctors().get(0).getPrescription(hospital.getPatients(), hospital.getDrugList());
        Map<String, Long> patientEndStates = patientManager.getPatientEndState(prescriptions);
        assertEquals(2, patientEndStates.get("H"));
        assertNull(patientEndStates.get("F"));
        assertNull(patientEndStates.get("D"));
    }

    @Test
    void integrationTest_cureFever() {
        Hospital hospital = hospitalManager.buildHospitalDetails("F P");
        List<PrescriptionDetails> prescriptions = hospital.getDoctors().get(0).getPrescription(hospital.getPatients(), hospital.getDrugList());
        Map<String, Long> patientEndStates = patientManager.getPatientEndState(prescriptions);
        assertEquals(1, patientEndStates.get("H"));
    }

}