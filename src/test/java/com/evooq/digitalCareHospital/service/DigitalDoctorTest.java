package com.evooq.digitalCareHospital.service;

import com.evooq.digitalCareHospital.domain.PrescriptionDetails;
import com.evooq.digitalCareHospital.engine.ImmatureStrategy;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DigitalDoctorTest {
    DigitalDoctor digitalDoctor = new DigitalDoctor();
    ImmatureStrategy immatureStrategy = new ImmatureStrategy();

    @Test
    void getPrescription_allParacetamol_patients_have_fever() {
        digitalDoctor.setTreatmentStrategy(immatureStrategy);
        List<PrescriptionDetails> prescriptionDetails = digitalDoctor.
                getPrescription(HospitalTestUtil.getPatientList(), HospitalTestUtil.getDrugList());
        for (PrescriptionDetails prescription : prescriptionDetails) {
            assertEquals("Fever", prescription.getPatient().getHealthState());
            assertEquals("Paracetamol", prescription.getPrescribedMedicine());
        }
    }

    @Test
    void getPrescription_all_patients_have_diabetes() {
        digitalDoctor.setTreatmentStrategy(immatureStrategy);
        List<PrescriptionDetails> prescriptionDetails = digitalDoctor.
                getPrescription(HospitalTestUtil.getPatientListWithDiabetes(), HospitalTestUtil.getInsulin());
        for (PrescriptionDetails prescription : prescriptionDetails) {
            assertEquals("Diabetes", prescription.getPatient().getHealthState());
            assertEquals("Insulin", prescription.getPrescribedMedicine());
        }
    }

    @Test
    void getPrescription_mixed_patients_mixed_drugs() {
        digitalDoctor.setTreatmentStrategy(immatureStrategy);
        List<PrescriptionDetails> prescriptionDetails = digitalDoctor.
                getPrescription(HospitalTestUtil.getPatientListWithMixedDiseases(), HospitalTestUtil.getMixedDoses());


        assertEquals("Insulin", prescriptionDetails.get(0).getPrescribedMedicine());
        assertEquals("Diabetes", prescriptionDetails.get(0).getPatient().getHealthState());
        assertEquals("Aspirin", prescriptionDetails.get(1).getPrescribedMedicine());
        assertEquals("Fever", prescriptionDetails.get(1).getPatient().getHealthState());
        assertEquals("Antibiotic", prescriptionDetails.get(2).getPrescribedMedicine());
        assertEquals("Tuberculosis", prescriptionDetails.get(2).getPatient().getHealthState());
    }
}