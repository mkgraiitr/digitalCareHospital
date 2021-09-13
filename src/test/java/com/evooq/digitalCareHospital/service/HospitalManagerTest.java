package com.evooq.digitalCareHospital.service;

import com.evooq.digitalCareHospital.domain.Hospital;
import com.evooq.digitalCareHospital.domain.PrescriptionDetails;
import com.evooq.digitalCareHospital.util.HospitalHelper;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class HospitalManagerTest {
    HospitalHelper hospitalHelper = new HospitalHelper();
    HospitalManager hospitalManager = new HospitalManager();
    PatientManager patientManager = new PatientManager();

    @Test
    void integrationTest_getFeverCured_allPatient() {
        Hospital hospital = hospitalHelper.buildHospitalDetails("F,F,F P,P,P");
        List<PrescriptionDetails> prescriptions = hospitalManager.getPrescription(hospital.getPatients(), hospital.getDrugList());
        Map<String, Long> patientEndStates = patientManager.getPatientEndState(prescriptions);
        assertEquals(3, patientEndStates.get("H"));
    }

    @Test
    void integrationTest_dead_diabeticPatient() {
        Hospital hospital = hospitalHelper.buildHospitalDetails("D,D");
        List<PrescriptionDetails> prescriptions = hospitalManager.getPrescription(hospital.getPatients(), hospital.getDrugList());
        Map<String, Long> patientEndStates = patientManager.getPatientEndState(prescriptions);
        assertEquals(2, patientEndStates.get("X"));
        assertNotEquals(2, patientEndStates.get("H"));
    }

    @Test
    void integrationTest_shortageOfDrugs() {
        Hospital hospital = hospitalHelper.buildHospitalDetails("F,F,F P");
        List<PrescriptionDetails> prescriptions = hospitalManager.getPrescription(hospital.getPatients(), hospital.getDrugList());
        Map<String, Long> patientEndStates = patientManager.getPatientEndState(prescriptions);
        assertEquals(1, patientEndStates.get("H"));
        assertEquals(2, patientEndStates.get("F"));
        assertNotEquals(1, patientEndStates.get("D"));
    }

    @Test
    void integrationTest_onePatient_manuDrugs() {
        Hospital hospital = hospitalHelper.buildHospitalDetails("F P,P,As,I,An");
        List<PrescriptionDetails> prescriptions = hospitalManager.getPrescription(hospital.getPatients(), hospital.getDrugList());
        Map<String, Long> patientEndStates = patientManager.getPatientEndState(prescriptions);
        assertEquals(1, patientEndStates.get("H"));
        assertNull(patientEndStates.get("F"));
        assertNull(patientEndStates.get("D"));
    }

    @Test
    void integrationTest_healthyPatients_noDrugs() {
        Hospital hospital = hospitalHelper.buildHospitalDetails("H,H");
        List<PrescriptionDetails> prescriptions = hospitalManager.getPrescription(hospital.getPatients(), hospital.getDrugList());
        Map<String, Long> patientEndStates = patientManager.getPatientEndState(prescriptions);
        assertEquals(2, patientEndStates.get("H"));
        assertNull(patientEndStates.get("F"));
        assertNull(patientEndStates.get("D"));
    }

    @Test
    void integrationTest_cureFever() {
        Hospital hospital = hospitalHelper.buildHospitalDetails("F P");
        List<PrescriptionDetails> prescriptions = hospitalManager.getPrescription(hospital.getPatients(), hospital.getDrugList());
        Map<String, Long> patientEndStates = patientManager.getPatientEndState(prescriptions);
        assertEquals(1, patientEndStates.get("H"));
    }

    @Test
    void integrationTest_onePatient_wrongDose_death() {
        Hospital hospital = hospitalHelper.buildHospitalDetails("H AsP");
        List<PrescriptionDetails> prescriptions = hospitalManager.getPrescription(hospital.getPatients(), hospital.getDrugList());
        Map<String, Long> patientEndStates = patientManager.getPatientEndState(prescriptions);
        assertEquals(1, patientEndStates.get("X"));
    }

    @Test
    void integrationTest_onePatient_wrongDose_death_2() {
        Hospital hospital = hospitalHelper.buildHospitalDetails("H PAs");
        List<PrescriptionDetails> prescriptions = hospitalManager.getPrescription(hospital.getPatients(), hospital.getDrugList());
        Map<String, Long> patientEndStates = patientManager.getPatientEndState(prescriptions);
        assertEquals(1, patientEndStates.get("X"));
    }

    @Test
    void integrationTest_onePatient_wrongDose_Fever() {
        Hospital hospital = hospitalHelper.buildHospitalDetails("H IAn");
        List<PrescriptionDetails> prescriptions = hospitalManager.getPrescription(hospital.getPatients(), hospital.getDrugList());
        Map<String, Long> patientEndStates = patientManager.getPatientEndState(prescriptions);
        assertEquals(1, patientEndStates.get("F"));
    }

    @Test
    void integrationTest_onePatient_wrongDose_Fever_2() {
        Hospital hospital = hospitalHelper.buildHospitalDetails("H AnI");
        List<PrescriptionDetails> prescriptions = hospitalManager.getPrescription(hospital.getPatients(), hospital.getDrugList());
        Map<String, Long> patientEndStates = patientManager.getPatientEndState(prescriptions);
        assertEquals(1, patientEndStates.get("F"));
    }

}